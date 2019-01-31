package com.coder.enhance.bean;

import lombok.Data;

import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
@Data
public class BaseConfigBean {

    protected String beanName;

    protected String classpath;

    protected String entityPath;

    protected String unCapitalizeBeanName;

    protected String packagePath;

    protected List<FieldBean> fields;

}
