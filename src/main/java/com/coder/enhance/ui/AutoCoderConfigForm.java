package com.coder.enhance.ui;

import com.coder.enhance.constant.JavaTypeMappingConstant;
import com.intellij.openapi.project.Project;

import javax.swing.*;

/**
 * @author jeffy
 * @date 2019-01-30
 **/
public class AutoCoderConfigForm {
    private Project project;
    private JPanel mainForm;
    private JTextField mapperSuffixField;
    private JLabel mapperSuffixLabel;
    private JLabel serviceSuffixLabel;
    private JTextField serviceSuffixField;
    private JTextField mapperPathField;
    private JTextField servicePathField;
    private JTextField serviceImplPathField;
    private JTextField dtoPathField;
    private JTextField junitTestPathField;
    private JTextField sqlPathField;
    private JLabel mapperPathLabel;
    private JLabel servicePathLabel;
    private JLabel dtoPathLabel;
    private JLabel serviceImplPathLabel;
    private JLabel junitTestPathLabel;
    private JLabel sqlPathLabel;
    private JTextField integerMappingField;
    private JLabel stringMappingLabel;
    private JLabel integerMappingLabel;
    private JTextField stringMappingField;
    private JTextField doubleMappingField;
    private JLabel doubleMappingLabel;
    private JLabel longMappingLabel;
    private JTextField longMappingField;
    private JLabel byteMappingLabel;
    private JTextField byteMappingFiled;
    private JRadioButton mysqlRadioButton;
    private JLabel dataBase;
    private JLabel codeSpecLabel;
    private JRadioButton camelRadio;
    private JRadioButton underlineRadio;
    private JLabel generateControllerLabel;
    private JCheckBox generateControllerCheckBox;
    private JRadioButton rpcRadioButton;
    private JRadioButton singleRadioButton;
    private JLabel applicationLabel;
    private JLabel charMappingLabel;
    private JTextField charMappingField;
    private JLabel useMybatisPenguinLabel;
    private JCheckBox useMybatisPenguinCheckBox;

    public AutoCoderConfigForm(Project project) {
        this.project = project;
        init();
    }

    private void init() {
        longMappingField.setText(JavaTypeMappingConstant.DEFAULT_LONG);
        stringMappingField.setText(JavaTypeMappingConstant.DEFAULT_STRING);
        byteMappingFiled.setText(JavaTypeMappingConstant.DEFAULT_BYTE);
        charMappingField.setText(JavaTypeMappingConstant.DEFAULT_CHAR);
        integerMappingField.setText(JavaTypeMappingConstant.DEFAULT_INTEGER);
        doubleMappingField.setText(JavaTypeMappingConstant.DEFAULT_DOUBLE);
    }

    public JPanel getMainForm() {
        return mainForm;
    }

    public void setMainForm(JPanel mainForm) {
        this.mainForm = mainForm;
    }

    public JTextField getMapperSuffixField() {
        return mapperSuffixField;
    }

    public void setMapperSuffixField(JTextField mapperSuffixField) {
        this.mapperSuffixField = mapperSuffixField;
    }

    public JLabel getMapperSuffixLabel() {
        return mapperSuffixLabel;
    }

    public void setMapperSuffixLabel(JLabel mapperSuffixLabel) {
        this.mapperSuffixLabel = mapperSuffixLabel;
    }

    public JLabel getServiceSuffixLabel() {
        return serviceSuffixLabel;
    }

    public void setServiceSuffixLabel(JLabel serviceSuffixLabel) {
        this.serviceSuffixLabel = serviceSuffixLabel;
    }

    public JTextField getServiceSuffixField() {
        return serviceSuffixField;
    }

    public void setServiceSuffixField(JTextField serviceSuffixField) {
        this.serviceSuffixField = serviceSuffixField;
    }

    public JTextField getMapperPathField() {
        return mapperPathField;
    }

    public void setMapperPathField(JTextField mapperPathField) {
        this.mapperPathField = mapperPathField;
    }

    public JTextField getServicePathField() {
        return servicePathField;
    }

    public void setServicePathField(JTextField servicePathField) {
        this.servicePathField = servicePathField;
    }

    public JTextField getServiceImplPathField() {
        return serviceImplPathField;
    }

    public void setServiceImplPathField(JTextField serviceImplPathField) {
        this.serviceImplPathField = serviceImplPathField;
    }

    public JTextField getDtoPathField() {
        return dtoPathField;
    }

    public void setDtoPathField(JTextField dtoPathField) {
        this.dtoPathField = dtoPathField;
    }

    public JTextField getJunitTestPathField() {
        return junitTestPathField;
    }

    public void setJunitTestPathField(JTextField junitTestPathField) {
        this.junitTestPathField = junitTestPathField;
    }

    public JTextField getSqlPathField() {
        return sqlPathField;
    }

    public void setSqlPathField(JTextField sqlPathField) {
        this.sqlPathField = sqlPathField;
    }

    public JLabel getMapperPathLabel() {
        return mapperPathLabel;
    }

    public void setMapperPathLabel(JLabel mapperPathLabel) {
        this.mapperPathLabel = mapperPathLabel;
    }

    public JLabel getServicePathLabel() {
        return servicePathLabel;
    }

    public void setServicePathLabel(JLabel servicePathLabel) {
        this.servicePathLabel = servicePathLabel;
    }

    public JLabel getDtoPathLabel() {
        return dtoPathLabel;
    }

    public void setDtoPathLabel(JLabel dtoPathLabel) {
        this.dtoPathLabel = dtoPathLabel;
    }

    public JLabel getServiceImplPathLabel() {
        return serviceImplPathLabel;
    }

    public void setServiceImplPathLabel(JLabel serviceImplPathLabel) {
        this.serviceImplPathLabel = serviceImplPathLabel;
    }

    public JLabel getJunitTestPathLabel() {
        return junitTestPathLabel;
    }

    public void setJunitTestPathLabel(JLabel junitTestPathLabel) {
        this.junitTestPathLabel = junitTestPathLabel;
    }

    public JLabel getSqlPathLabel() {
        return sqlPathLabel;
    }

    public void setSqlPathLabel(JLabel sqlPathLabel) {
        this.sqlPathLabel = sqlPathLabel;
    }

    public JTextField getIntegerMappingField() {
        return integerMappingField;
    }

    public void setIntegerMappingField(JTextField integerMappingField) {
        this.integerMappingField = integerMappingField;
    }

    public JLabel getStringMappingLabel() {
        return stringMappingLabel;
    }

    public void setStringMappingLabel(JLabel stringMappingLabel) {
        this.stringMappingLabel = stringMappingLabel;
    }

    public JLabel getIntegerMappingLabel() {
        return integerMappingLabel;
    }

    public void setIntegerMappingLabel(JLabel integerMappingLabel) {
        this.integerMappingLabel = integerMappingLabel;
    }

    public JTextField getStringMappingField() {
        return stringMappingField;
    }

    public void setStringMappingField(JTextField stringMappingField) {
        this.stringMappingField = stringMappingField;
    }

    public JTextField getDoubleMappingField() {
        return doubleMappingField;
    }

    public void setDoubleMappingField(JTextField doubleMappingField) {
        this.doubleMappingField = doubleMappingField;
    }

    public JLabel getDoubleMappingLabel() {
        return doubleMappingLabel;
    }

    public void setDoubleMappingLabel(JLabel doubleMappingLabel) {
        this.doubleMappingLabel = doubleMappingLabel;
    }

    public JLabel getLongMappingLabel() {
        return longMappingLabel;
    }

    public void setLongMappingLabel(JLabel longMappingLabel) {
        this.longMappingLabel = longMappingLabel;
    }

    public JTextField getLongMappingField() {
        return longMappingField;
    }

    public void setLongMappingField(JTextField longMappingField) {
        this.longMappingField = longMappingField;
    }

    public JLabel getByteMappingLabel() {
        return byteMappingLabel;
    }

    public void setByteMappingLabel(JLabel byteMappingLabel) {
        this.byteMappingLabel = byteMappingLabel;
    }

    public JTextField getByteMappingFiled() {
        return byteMappingFiled;
    }

    public void setByteMappingFiled(JTextField byteMappingFiled) {
        this.byteMappingFiled = byteMappingFiled;
    }

    public JRadioButton getMysqlRadioButton() {
        return mysqlRadioButton;
    }

    public void setMysqlRadioButton(JRadioButton mysqlRadioButton) {
        this.mysqlRadioButton = mysqlRadioButton;
    }

    public JLabel getDataBase() {
        return dataBase;
    }

    public void setDataBase(JLabel dataBase) {
        this.dataBase = dataBase;
    }

    public JLabel getCodeSpecLabel() {
        return codeSpecLabel;
    }

    public void setCodeSpecLabel(JLabel codeSpecLabel) {
        this.codeSpecLabel = codeSpecLabel;
    }

    public JRadioButton getCamelRadio() {
        return camelRadio;
    }

    public void setCamelRadio(JRadioButton camelRadio) {
        this.camelRadio = camelRadio;
    }

    public JRadioButton getUnderlineRadio() {
        return underlineRadio;
    }

    public void setUnderlineRadio(JRadioButton underlineRadio) {
        this.underlineRadio = underlineRadio;
    }

    public JLabel getGenerateControllerLabel() {
        return generateControllerLabel;
    }

    public void setGenerateControllerLabel(JLabel generateControllerLabel) {
        this.generateControllerLabel = generateControllerLabel;
    }

    public JCheckBox getGenerateControllerCheckBox() {
        return generateControllerCheckBox;
    }

    public void setGenerateControllerCheckBox(JCheckBox generateControllerCheckBox) {
        this.generateControllerCheckBox = generateControllerCheckBox;
    }

    public JRadioButton getRpcRadioButton() {
        return rpcRadioButton;
    }

    public void setRpcRadioButton(JRadioButton rpcRadioButton) {
        this.rpcRadioButton = rpcRadioButton;
    }

    public JRadioButton getSingleRadioButton() {
        return singleRadioButton;
    }

    public void setSingleRadioButton(JRadioButton singleRadioButton) {
        this.singleRadioButton = singleRadioButton;
    }

    public JLabel getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(JLabel applicationLabel) {
        this.applicationLabel = applicationLabel;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public JLabel getCharMappingLabel() {
        return charMappingLabel;
    }

    public void setCharMappingLabel(JLabel charMappingLabel) {
        this.charMappingLabel = charMappingLabel;
    }

    public JTextField getCharMappingField() {
        return charMappingField;
    }

    public void setCharMappingField(JTextField charMappingField) {
        this.charMappingField = charMappingField;
    }

    public JLabel getUseMybatisPenguinLabel() {
        return useMybatisPenguinLabel;
    }

    public void setUseMybatisPenguinLabel(JLabel useMybatisPenguinLabel) {
        this.useMybatisPenguinLabel = useMybatisPenguinLabel;
    }

    public JCheckBox getUseMybatisPenguinCheckBox() {
        return useMybatisPenguinCheckBox;
    }

    public void setUseMybatisPenguinCheckBox(JCheckBox useMybatisPenguinCheckBox) {
        this.useMybatisPenguinCheckBox = useMybatisPenguinCheckBox;
    }
}
