package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.exception.AutoCoderException;

/**
 * @author jeffy
 * @date 2019-02-03
 **/
public class JunitTestConfigBeanBuilder implements BeanBuilder {

    private Configuration configuration;

    private ClassBean classBean;

    public JunitTestConfigBeanBuilder(Configuration configuration, ClassBean classBean) {
        this.configuration = configuration;
        this.classBean = classBean;
    }

    @Override
    public ClassBean build() throws AutoCoderException {
        return null;
    }
}
