package me.willclub.learnmaterialdesign.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by will on 4/23/15.
 */
public class DrawableUtil {

    public static Drawable getDrawable(Context mContext, int resId) {
        if (resId < 0) {
            return null;
        }
        return mContext.getResources().getDrawable(resId, null);
    }

}
