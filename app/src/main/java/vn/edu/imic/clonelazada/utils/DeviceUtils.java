package vn.edu.imic.clonelazada.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

import java.util.Locale;

/**
 * Created by MyPC on 02/03/2018.
 */

public class DeviceUtils {
    public static String getDeviceName(){
        String manufacture = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacture)){
            return "Device name: " + capitalize(model);
        }
        return "Device name: " + capitalize(manufacture) +
                MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + model;
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        //Lấy ra ký tự đầu tiên
        char first = s.charAt(0);
        return !Character.isUpperCase(first) ? Character.toUpperCase(first) + s.substring(1)
                : s;
    }

    /**
     * Ngôn ngữ hiện tại
     * @return
     */
    public static String getCurrentLanguage(){
        return "Language: " + Locale.getDefault().getDisplayLanguage();
    }

    /**
     * Lấy kích thước màn hình(mảng)
     * @return
     */
    public static int[] getScreenSize(){
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        return new int[]{width,height};
    }

    /**
     *
     * @return Android version
     */
    public static String getAndroidVersion(){
        return "Android SDK: " + Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
    }

    /**
     *
     * @param context
     * @return density of device
     */
    public static String getDensity(Context context){
        float density = context.getResources().getDisplayMetrics().density;
        if ((double)density >= 4.0d ){
            return "xxxhdpi";
        }else if ((double) density >= 3.0d){
            return "xxhdpi";
        }else if ((double) density >= 2.0d){
            return "xhdpi";
        }else if ((double) density >= 1.5d){
            return "hdpi";
        }else if ((double) density >= 1.0d){
            return "mdpi";
        }else {
            return "ldpi";
        }
    }

    /**
     *
     * @param context
     * @return trả về thuộc loại thiết bị nào()
     */
    public static String getCategoryScreenSize(Context context){
        int screen = context.getResources().getConfiguration().screenLayout & 15;
        if (screen == 4){
            return "X-LARGE";
        }else if (screen == 3){
            return "LARGE";
        }else if (screen == 2){
            return "NORMAL";
        }else if (screen == 1){
            return "SMALL";
        }else {
            return "NORMAL or SMALL";
        }
    }

    public static boolean isBrokenSamsungDevice(){
        return Build.MANUFACTURER.equalsIgnoreCase("samsung")
                && isBetweenAndroidVersion(21,26);
    }

    /**
     *
     * @param min sdk min
     * @param max sdk max
     * @return true nếu nằm trong phiên bản min, max
     */
    private static boolean isBetweenAndroidVersion(int min, int max) {
        return Build.VERSION.SDK_INT >= min && Build.VERSION.SDK_INT <= max;
    }

    /**
     *
     * @param context
     * @return true nếu là lần đầu cài đặt
     */
    public static boolean isFirstInstall(Context context){
        //Lấy ra package name
        String packageName = context.getPackageName();
        boolean isFirstInstall = false;
        try {
            if (context.getPackageManager().getPackageInfo(packageName,0)
                    .firstInstallTime != context.getPackageManager().getPackageInfo(packageName,0).lastUpdateTime){
                isFirstInstall = true;
            }
            return isFirstInstall;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }

    /**
     *
     * @param context
     * @return
     */
    public static boolean installFromUpdate(Context context){
        String packageName = context.getPackageName();
        boolean isInstallFromUpdate = false;
        try{
            if (context.getPackageManager().getPackageInfo(packageName,0).firstInstallTime
                    != context.getPackageManager().getPackageInfo(packageName,0).lastUpdateTime){
                isInstallFromUpdate = true;
            }
            return isInstallFromUpdate;
        }catch (PackageManager.NameNotFoundException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
