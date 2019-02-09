package com.coder.enhance.enums;

import com.coder.enhance.bean.Configuration;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public enum JavaBasicTypeEnum {

    INT_TYPE("int", "Integer"),
    STRING_TYPE("String", "String"),
    DOUBLE_TYPE("double", "Double"),
    LONG_TYPE("long", "Long"),
    DATE_TYPE("Date","Date"),
    CHAR_TYPE("char", "Char");

    private String basicType;

    private String packageType;


    private static final Map<String, JavaBasicTypeEnum> TYPE_ENUM_MAP = Maps.newHashMap();

    static {
        for (JavaBasicTypeEnum value : JavaBasicTypeEnum.values()) {
            TYPE_ENUM_MAP.put(value.getBasicType().toLowerCase(), value);
        }
    }

    public static JavaBasicTypeEnum getTypeByBasicType(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return TYPE_ENUM_MAP.get(key.toLowerCase());
    }

    public static final String getTypeMappingConfigByType(String key, Configuration configuration) {
        if (null == configuration) {
            return "";
        }
        if (INT_TYPE.basicType.equalsIgnoreCase(key)) {
            return configuration.getIntegerMapping();
        }
        if (STRING_TYPE.basicType.equalsIgnoreCase(key)) {
            return configuration.getStringMapping();
        }
        if (DOUBLE_TYPE.basicType.equalsIgnoreCase(key)) {
            return configuration.getDoubleMapping();
        }
        if (LONG_TYPE.basicType.equalsIgnoreCase(key)) {
            return configuration.getLongMapping();
        }
        if (CHAR_TYPE.basicType.equalsIgnoreCase(key)) {
            return configuration.getCharMapping();
        }
        if(DATE_TYPE.basicType.equalsIgnoreCase(key)){
            return " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ";
        }
        return "";
    }

    public String getBasicType() {
        return basicType;
    }

    public void setBasicType(String basicType) {
        this.basicType = basicType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    JavaBasicTypeEnum(String basicType, String packageType) {
        this.basicType = basicType;
        this.packageType = packageType;
    }
}
