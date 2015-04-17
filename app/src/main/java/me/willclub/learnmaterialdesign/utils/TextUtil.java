package me.willclub.learnmaterialdesign.utils;

/**
 * Created by will on 4/10/15.
 */
public class TextUtil {

    public static boolean isValid(CharSequence str) {
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

}
