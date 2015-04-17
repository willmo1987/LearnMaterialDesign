package me.willclub.learnmaterialdesign.utils;

import android.util.Log;

import me.willclub.learnmaterialdesign.BuildConfig;


/**
 * Created by will on 4/10/15.
 */
public class Trace {

    private static final String TAG = "eWashTag";

    public static void e(String msg) {
        if (BuildConfig.LOG_ENABLED) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (BuildConfig.LOG_ENABLED) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (BuildConfig.LOG_ENABLED) {
            Log.w(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (BuildConfig.LOG_ENABLED) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (BuildConfig.LOG_ENABLED) {
            Log.v(TAG, msg);
        }
    }

    public static void logException(Exception e) {
        if (BuildConfig.LOG_ENABLED) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    public static void logCurrentThread(String fromWhere) {
        if (BuildConfig.LOG_ENABLED) {
            Log.d(TAG, fromWhere + " is in thread " +
                    Thread.currentThread().getName() + "    " + Thread.currentThread().getId());
        }
    }

}
