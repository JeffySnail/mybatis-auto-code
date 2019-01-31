package com.coder.enhance.enums;

public enum DataBaseEnum {
    MYSQL("mysql"),
    ORACLE("oracle");

    private String name;

    DataBaseEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
