package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.exception.AutoCoderException;

/**
 * @author jeffy
 * @date 2019-02-02
 **/
public class ControllerConfigBeanBuilder implements BeanBuilder {

    private ClassBean classBean;

    private Configuration configuration;


    public ControllerConfigBeanBuilder(ClassBean classBean, Configuration configuration) {
        this.classBean = classBean;
        this.configuration = configuration;
    }

    @Override
    public ClassBean build() throws AutoCoderException {

        return null;
    }
}
