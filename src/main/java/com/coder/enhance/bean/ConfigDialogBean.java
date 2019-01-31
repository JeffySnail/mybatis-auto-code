package com.coder.enhance.bean;

import com.coder.enhance.enums.ApplicationEnum;
import com.coder.enhance.enums.CodeSpecEnum;
import com.coder.enhance.enums.DataBaseEnum;
import com.coder.enhance.ui.AutoCoderConfigForm;
import com.intellij.openapi.project.Project;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
@Data
public class ConfigDialogBean implements Serializable {

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

    private boolean generateController;

    private boolean useMybatisPenguin;

    public ConfigDialogBean(Project project) {
        this.project = project;
    }

    public ConfigDialogBean(Project project, AutoCoderConfigForm form, String classpath, String entityPath) {
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

    }
}
