package com.coder.enhance.enums;

import com.google.common.collect.Maps;

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
        if (key.isEmpty()) {
            return null;
        }
        return TYPE_ENUM_MAP.get(key.toLowerCase());
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
