package com.jinke.community.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by root on 16-11-13.
 */
public class ToastUtils {

    public static void showLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT);
    }
}
