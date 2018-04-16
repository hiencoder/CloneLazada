package vn.edu.imic.clonelazada.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;
/**
 * Created by MyPC on 28/02/2018.
 */

public class PrefUtils {
    //Các trường cần lưu trong shared
    public static final String FILE_SHARED = "";

    public PrefUtils(){}

    private static SharedPreferences getDefaultSharedPreferences(Context context){
        //Lấy ra một thể hiện của SharedPreferences được cung cấp bởi framework
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     *
     * @param key
     * @param value
     */
    public static void saveInt(Context context, String key, int value){
        Editor editor = getDefaultSharedPreferences(context).edit();
        editor.putInt(key,value);
        editor.apply();
    }

    /**
     *
     * @param context
     * @param key
     * @param value
     */
    public static void saveLong(Context context, String key, long value){
       Editor editor = getDefaultSharedPreferences(context).edit();
       editor.putLong(key,value);
       editor.apply();
    }

    /**
     *
     * @param context
     * @param key
     * @param value
     */
    public static void saveBoolean(Context context, String key, boolean value){
        Editor editor = getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    /**
     *
     * @param context
     * @param key
     * @param value
     */
    public static void saveString(Context context, String key, String value){
        Editor editor = getDefaultSharedPreferences(context).edit();
        editor.putString(key,value);
        editor.apply();
    }

    /**
     * Lưu giá trị float
     * @param context
     * @param key
     * @param value
     */
    public static void saveFloat(Context context, String key, float value){
        Editor editor = getDefaultSharedPreferences(context).edit();
        editor.putFloat(key,value);
        editor.apply();
    }

    //Lấy ra các giá trị trong shared
    public static int getInt(Context context, String key, int defaultValue){
        return getDefaultSharedPreferences(context).getInt(key,defaultValue);
    }

    public static long getLong(Context context, String key, long defaultValue){
        return getDefaultSharedPreferences(context).getLong(key,defaultValue);
    }

    public static String getString(Context context, String key, String defaultValue){
        return getDefaultSharedPreferences(context).getString(key, defaultValue);
    }

    public static float getFloat(Context context, String key, float defaultValue){
        return getDefaultSharedPreferences(context).getFloat(key,defaultValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue){
        return getDefaultSharedPreferences(context).getBoolean(key,defaultValue);
    }

    //Xóa 1 trường trong shared
    public static void remove(Context context, String key){
        Editor editor = getDefaultSharedPreferences(context).edit();
        editor.remove(key);
        editor.apply();
    }
}
