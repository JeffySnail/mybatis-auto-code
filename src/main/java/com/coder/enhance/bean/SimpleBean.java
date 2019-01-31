package com.coder.enhance.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
@Data
public class SimpleBean implements Serializable {

    private String beanName;

    private String simpleBeanName;

    private String comment;

    private List<FieldBean> fields;
}
