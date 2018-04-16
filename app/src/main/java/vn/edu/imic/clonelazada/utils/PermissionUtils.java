package vn.edu.imic.clonelazada.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;


/**
 * Created by MyPC on 28/02/2018.
 */

public class PermissionUtils {
    /**
     * Kiểm tra thiết bị nếu android 5 trở xuống
     * @param activity
     * @return
     */
    public static boolean isPermissionOverlayGranted(Activity activity){
        if (VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)){
            return true;
        }
        return false;
    }

    /**
     * Kiểm tra quyền call đã được cấp hay chưa
     * @param context
     * @return
     */
    public static boolean isPermissionCallGranted(Context context){
        if (VERSION.SDK_INT >= 23 &&
                ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //Nếu chưa được cấp quyền call
            return false;
        }
        return true;
    }

    /**
     * Kiểm tra quyền danh bạ
     * @param context
     * @return
     */
    public static boolean isPermissionContactGranted(Context context){
        if(VERSION.SDK_INT >= 23 &&
                ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }

    /**
     * Quyền gửi tin nhắn
     * @param context
     * @return
     */
    public static boolean isPermissionSendSmsGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.SEND_SMS) != 0){
            return false;
        }
        return true;
    }

    /**
     * Quyền lấy trạng thái cuộc gọi
     * @param context
     * @return
     */
    public static boolean isPermissionPhoneStateGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.READ_PHONE_STATE) != 0){
            return false;
        }
        return true;
    }

    /**
     * Check quyền lấy ra vị trí
     * @param context
     * @return
     */
    public static boolean isPermissionLocationGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != 0){
            return false;
        }
        return true;
    }

    /**
     * Check quyền accoutn
     * @param context
     * @return
     */
    public static boolean isPermissionGetAccountGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.GET_ACCOUNTS) != 0){
            return false;
        }
        return true;
    }

    /**
     * Check quyền đọc bộ nhớ ngoài
     * @param context
     * @return
     */
    public static boolean isPermissionReadExternalStorage(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) != 0){
            return false;
        }
        return true;
    }
}
