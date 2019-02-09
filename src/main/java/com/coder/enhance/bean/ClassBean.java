package com.coder.enhance.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class ClassBean implements Serializable {

    protected String comment;

    protected String beanName;

    protected String classpath;

    protected String entityPath;

    protected String unCapitalizeBeanName;

    protected String packagePath;

    protected List<FieldBean> fields;

    protected String charset;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public String getEntityPath() {
        return entityPath;
    }

    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public String getUnCapitalizeBeanName() {
        return unCapitalizeBeanName;
    }

    public void setUnCapitalizeBeanName(String unCapitalizeBeanName) {
        this.unCapitalizeBeanName = unCapitalizeBeanName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
