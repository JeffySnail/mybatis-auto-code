package com.coder.enhance.bean;

import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class XmlConfigConfigBean extends ClassBean {

    private String tableName;

    private String type;

    private String allFields;

    private String idType;

    private List<FieldBean> insertFields;

    private List<String> insertValues;

    private List<String> insertValuesWithNoBeanName;

    private String nameSpace;

    private boolean useMybatisPenguin;

    public boolean isUseMybatisPenguin() {
        return useMybatisPenguin;
    }

    public void setUseMybatisPenguin(boolean useMybatisPenguin) {
        this.useMybatisPenguin = useMybatisPenguin;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAllFields() {
        return allFields;
    }

    public void setAllFields(String allFields) {
        this.allFields = allFields;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public List<FieldBean> getInsertFields() {
        return insertFields;
    }

    public void setInsertFields(List<FieldBean> insertFields) {
        this.insertFields = insertFields;
    }

    public List<String> getInsertValues() {
        return insertValues;
    }

    public void setInsertValues(List<String> insertValues) {
        this.insertValues = insertValues;
    }

    public List<String> getInsertValuesWithNoBeanName() {
        return insertValuesWithNoBeanName;
    }

    public void setInsertValuesWithNoBeanName(List<String> insertValuesWithNoBeanName) {
        this.insertValuesWithNoBeanName = insertValuesWithNoBeanName;
    }
}
