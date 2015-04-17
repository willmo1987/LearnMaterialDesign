package me.willclub.learnmaterialdesign.utils;

/**
 * Created by will on 4/15/15.
 */
public class ArrayUtil {

    public static <T> boolean isValid(T[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return true;
    }

}
