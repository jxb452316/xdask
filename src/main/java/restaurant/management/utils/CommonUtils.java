package restaurant.management.utils;

/**
 * CommonUtils
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/1 - created by zhe.jiang
 */
public class CommonUtils {

    public static String nullIfEmpty(String str) {
        if (str == null || str.isEmpty())
            return null;
        return str;
    }
}
