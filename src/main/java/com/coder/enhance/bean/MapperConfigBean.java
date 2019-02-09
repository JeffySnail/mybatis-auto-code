package com.coder.enhance.bean;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class MapperConfigBean extends ClassBean {
    private String interfaceName;

    private String packagePath;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public String getPackagePath() {
        return packagePath;
    }

    @Override
    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
