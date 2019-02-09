package com.coder.enhance.bean;

import java.io.Serializable;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class ServiceConfigBean extends ClassBean implements Serializable {

    private String packagePath;

    private String serviceName;

    private String dtoPath = "";

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDtoPath() {
        return dtoPath;
    }

    public void setDtoPath(String dtoPath) {
        this.dtoPath = dtoPath;
    }
}
