package com.coder.enhance.bean;

import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class SqlConfigBean extends ClassBean {

    private String tableName;

    private List<String> fieldStrList;

    private String tableComment;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<String> getFieldStrList() {
        return fieldStrList;
    }

    public void setFieldStrList(List<String> fieldStrList) {
        this.fieldStrList = fieldStrList;
    }
}
