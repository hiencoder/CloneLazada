package vn.edu.imic.clonelazada.utils;

import android.util.Log;

/**
 * Created by MyPC on 28/02/2018.
 */

public class Logger {
    private static boolean LOGGING_ENABLE = true;
    private static final int STACK_TRACE_LEVEL = 5;
    public static final String TAG = "CloneLazada";

    public static void d(String message) {
        if (LOGGING_ENABLE) {
            Log.d(TAG, getClassNameMethodNameAndLineNumber() + message);
        }
    }


    public static void i(String message) {
        if (LOGGING_ENABLE) {
            Log.i(TAG, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    public static void v(String message) {
        if (LOGGING_ENABLE) {
            Log.v(TAG, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    public static void e(String message) {
        if (LOGGING_ENABLE) {
            Log.e(TAG, getClassNameMethodNameAndLineNumber() + message);
        }
    }

    //Lấy ra vị trí dòng code đc log
    public static int getLineNumber(){
        return Thread.currentThread().getStackTrace()[STACK_TRACE_LEVEL].getLineNumber();
    }

    //Get class name
    public static String getClassName(){
        String fileName = Thread.currentThread().getStackTrace()[STACK_TRACE_LEVEL].getClassName();
        return fileName.substring(0,fileName.length()-5);
    }

    //Get method name
    public static String getMethodName(){
        return Thread.currentThread().getStackTrace()[5].getMethodName();
    }

    private static String getClassNameMethodNameAndLineNumber() {
        return "[" + getClassName() + "." + getMethodName() + "()-" + getLineNumber() + "]";
    }

}
