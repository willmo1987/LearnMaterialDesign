package me.willclub.learnmaterialdesign.utils;

import java.util.Collection;

/**
 * Created by will on 4/10/15.
 */
public class CollectionUtil {

    public static boolean isValid(Collection collection) {
        if (collection != null && collection.size() > 0) {
            return true;
        }
        return false;
    }

}
