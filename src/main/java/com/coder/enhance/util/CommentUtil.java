package com.coder.enhance.util;

/**
 * @author jeffy
 * @date 2019-02-01
 **/
public class CommentUtil {

    public static String formatText(String text) {
        text = text.replace("/*", "");
        text = text.replace("*/", "");
        text = text.replace("//", "");
        text = text.replace("\n", "");
        text = text.replace("*", "");
        text = text.trim();
        return text;
    }
}
