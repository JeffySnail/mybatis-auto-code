package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.ServiceConfigBean;
import com.coder.enhance.exception.AutoCoderException;

/**
 * @author jeffy
 * @date 2019-02-03
 **/
public class ServiceConfigBeanBuilder implements BeanBuilder {

    private Configuration configuration;

    private ClassBean classBean;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public ClassBean getClassBean() {
        return classBean;
    }

    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }

    @Override
    public ClassBean build() throws AutoCoderException {
        ServiceConfigBean serviceConfigBean = new ServiceConfigBean();
//        serviceConfigBean.setDtoPath();
        return serviceConfigBean;
    }
}
