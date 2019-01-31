package com.coder.enhance.enums;

public enum ApplicationEnum {
    RPC("rpc","rpc model will generate dto "),
    SINGLE("single","single application "),
    ;

    private String name;

    private String desc;

    ApplicationEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
