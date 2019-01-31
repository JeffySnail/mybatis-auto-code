package com.coder.enhance.enums;

public enum CodeSpecEnum {
    UNDERLINE("underline"),
    CAMEL("camel"),
    ;

    private String name;

    CodeSpecEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
