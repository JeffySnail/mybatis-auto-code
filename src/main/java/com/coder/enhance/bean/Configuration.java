package com.coder.enhance.bean;

import com.coder.enhance.enums.ApplicationEnum;
import com.coder.enhance.enums.CodeSpecEnum;
import com.coder.enhance.enums.DataBaseEnum;
import com.coder.enhance.ui.AutoCoderConfigForm;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;

import java.io.Serializable;
import java.util.List;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class Configuration implements Serializable {

    public static final List<String> MUST_HAS_FIELDS = Lists.newArrayList("id", "addTime", "updateTime");

    private Project project;

    private String classpath;

    private String entityPath;

    private String doubleMapping;

    private String charMapping;

    private String longMapping;

    private String stringMapping;

    private String integerMapping;

    private String byteMapping;

    private String mapperPath;

    private String servicePath;

    private String mapperSuffix;

    private String serviceSuffix;

    private String dtoPath;

    private String serviceImplPath;

    private String junitTestPath;

    private String sqlPath;

    private String database;

    private String codeSpec;

    private String application;

    private String charset;

    private boolean generateController;

    private boolean useMybatisPenguin;

    public Configuration(Project project) {
        this.project = project;
    }

    public Configuration(Project project, AutoCoderConfigForm form, String classpath, String entityPath) {
        this.project = project;
        this.classpath = classpath;
        this.entityPath = entityPath;

        this.mapperSuffix = form.getMapperSuffixField().getText();
        this.serviceSuffix = form.getServiceSuffixField().getText();

        this.dtoPath = form.getDtoPathField().getText();
        this.junitTestPath = form.getJunitTestPathField().getText();
        this.serviceImplPath = form.getServiceImplPathField().getText();
        this.servicePath = form.getServicePathField().getText();
        this.mapperPath = form.getMapperPathField().getText();
        this.sqlPath = form.getSqlPathField().getText();

        this.byteMapping = form.getByteMappingFiled().getText();
        this.charMapping = form.getCharMappingField().getText();
        this.longMapping = form.getLongMappingField().getText();
        this.stringMapping = form.getStringMappingField().getText();
        this.doubleMapping = form.getDoubleMappingField().getText();
        this.integerMapping = form.getIntegerMappingField().getText();


        this.database = form.getMysqlRadioButton().isSelected() ? DataBaseEnum.MYSQL.getName() : DataBaseEnum.ORACLE.getName();

        this.codeSpec = form.getUnderlineRadio().isSelected() ? CodeSpecEnum.UNDERLINE.getName() : CodeSpecEnum.CAMEL.getName();

        this.application = form.getRpcRadioButton().isSelected() ? ApplicationEnum.RPC.getName() : ApplicationEnum.SINGLE.getName();

        this.generateController = form.getGenerateControllerCheckBox().isSelected();

        this.useMybatisPenguin = form.getUseMybatisPenguinCheckBox().isSelected();

        this.charset = form.getCharsetField().getText();

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public String getDoubleMapping() {
        return doubleMapping;
    }

    public void setDoubleMapping(String doubleMapping) {
        this.doubleMapping = doubleMapping;
    }

    public String getCharMapping() {
        return charMapping;
    }

    public void setCharMapping(String charMapping) {
        this.charMapping = charMapping;
    }

    public String getLongMapping() {
        return longMapping;
    }

    public void setLongMapping(String longMapping) {
        this.longMapping = longMapping;
    }

    public String getStringMapping() {
        return stringMapping;
    }

    public void setStringMapping(String stringMapping) {
        this.stringMapping = stringMapping;
    }

    public String getIntegerMapping() {
        return integerMapping;
    }

    public void setIntegerMapping(String integerMapping) {
        this.integerMapping = integerMapping;
    }

    public String getByteMapping() {
        return byteMapping;
    }

    public void setByteMapping(String byteMapping) {
        this.byteMapping = byteMapping;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getMapperSuffix() {
        return mapperSuffix;
    }

    public void setMapperSuffix(String mapperSuffix) {
        this.mapperSuffix = mapperSuffix;
    }

    public String getServiceSuffix() {
        return serviceSuffix;
    }

    public void setServiceSuffix(String serviceSuffix) {
        this.serviceSuffix = serviceSuffix;
    }

    public String getDtoPath() {
        return dtoPath;
    }

    public void setDtoPath(String dtoPath) {
        this.dtoPath = dtoPath;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    public String getJunitTestPath() {
        return junitTestPath;
    }

    public void setJunitTestPath(String junitTestPath) {
        this.junitTestPath = junitTestPath;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(String codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public boolean isGenerateController() {
        return generateController;
    }

    public void setGenerateController(boolean generateController) {
        this.generateController = generateController;
    }

    public boolean isUseMybatisPenguin() {
        return useMybatisPenguin;
    }

    public void setUseMybatisPenguin(boolean useMybatisPenguin) {
        this.useMybatisPenguin = useMybatisPenguin;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
