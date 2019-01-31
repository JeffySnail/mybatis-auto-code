package com.coder.enhance.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
@Data
public class FieldBean implements Serializable {

    private String comment;

    private String type;

    private String fieldName;

    private String columnName;

}
