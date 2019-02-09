package com.coder.enhance.util;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;

/**
 * @author jeffy
 * @date 2019-02-04
 **/
public class CodeSpecUtil {
    public static String getUnderScore(String value) {
        if (value == null) {
            return StringUtils.EMPTY;
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, value);
    }

    public static String getLowerCamel(String value) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, value);
    }

    public static void main(String[] args) {

        System.err.println(getUnderScore("homeCase"));
    }
}
