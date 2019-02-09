package com.coder.enhance.bean;

import java.io.Serializable;

/**
 * @author jeffy
 * @date 2019-01-31
 **/

public class FieldBean implements Serializable {

    private String comment;

    private String type;

    private String fieldName;

    private String columnName;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
