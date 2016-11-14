package com.jinke.community.utils;

import android.util.Log;

/**
 * Created by root on 16-11-13.
 */
public class LogUtils {

    public static boolean isDebug = true;
    public static String tag="wan";

    public static void e(String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }

    }

    public static void w( String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void v( String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }


    public static void d(String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }
}
