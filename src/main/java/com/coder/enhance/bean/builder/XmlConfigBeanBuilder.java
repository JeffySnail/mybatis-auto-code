package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.FieldBean;
import com.coder.enhance.bean.XmlConfigConfigBean;
import com.coder.enhance.enums.CodeSpecEnum;
import com.coder.enhance.enums.JavaBasicTypeEnum;
import com.coder.enhance.exception.AutoCoderException;
import com.coder.enhance.util.CodeSpecUtil;
import com.coder.enhance.util.PathUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jeffy
 * @date 2019-02-02
 **/
public class XmlConfigBeanBuilder implements BeanBuilder {

    private ClassBean classBean;

    private Configuration configuration;

    public XmlConfigBeanBuilder(ClassBean classBean, Configuration configuration) {
        this.classBean = classBean;
        this.configuration = configuration;
    }

    @Override
    public ClassBean build() throws AutoCoderException {
        XmlConfigConfigBean configConfigBean = new XmlConfigConfigBean();
        configConfigBean.setBeanName(classBean.getBeanName());
        configConfigBean.setNameSpace(PathUtil.replaceLine(configuration.getMapperPath() + "." + classBean.getBeanName() + configuration.getMapperSuffix()));
        configConfigBean.setType(PathUtil.replaceLine(PathUtil.getRelativePath(configuration.getEntityPath() + "." + classBean.getBeanName())));
        configConfigBean.setUnCapitalizeBeanName(StringUtils.uncapitalize(classBean.getBeanName()));
        configConfigBean.setUseMybatisPenguin(configuration.isUseMybatisPenguin());
        this.insertFields(configConfigBean, classBean.getFields());
        configConfigBean.setTableName(classBean.getBeanName());

        if (CodeSpecEnum.CAMEL.getName().equals(configuration.getCodeSpec())) {
            List<FieldBean> fieldList = classBean.getFields();
            if (null != fieldList && fieldList.size() > 0) {
                for (FieldBean fieldInfo : fieldList) {
                    fieldInfo.setColumnName(StringUtils.capitalize(fieldInfo.getFieldName()));
                }
            }
            configConfigBean.setFields(fieldList);
        } else {
            List<FieldBean> fieldList = classBean.getFields();
            if (null != fieldList && fieldList.size() > 0) {
                for (FieldBean fieldInfo : fieldList) {
                    fieldInfo.setColumnName(CodeSpecUtil.getUnderScore(fieldInfo.getFieldName()));
                }
            }
            configConfigBean.setFields(fieldList);
        }
        configConfigBean.setAllFields(allFields());
        configConfigBean.setIdType(this.getIdType(classBean.getFields()));

        return configConfigBean;
    }

    private String allFields() {
        StringBuilder stringBuffer = new StringBuilder("");
        if (CollectionUtils.isNotEmpty(classBean.getFields())) {
            for (FieldBean fieldInfo : classBean.getFields()) {
                stringBuffer.append(",").append(fieldInfo.getColumnName()).append("\n");
            }
            stringBuffer.deleteCharAt(0);
        }
        return stringBuffer.toString();
    }


    private void insertFields(XmlConfigConfigBean xmlContentBean, List<FieldBean> fieldList) {
        List<FieldBean> noIdFields = fieldList.stream().filter(e -> !e.getFieldName().equalsIgnoreCase("id")).collect(Collectors.toList());
        xmlContentBean.setInsertFields(noIdFields);
        List<String> values = new ArrayList<>();
        List<String> valuesWithNoBeanName = new ArrayList<>();
        for (FieldBean noIdField : noIdFields) {
            if (null != noIdField.getType() && noIdField.getType().toUpperCase().contains("DATE")) {
                values.add("NOW()");
                valuesWithNoBeanName.add("NOW()");
            } else {
                values.add("#{" + xmlContentBean.getUnCapitalizeBeanName() + "." + noIdField.getFieldName() + "}");
                valuesWithNoBeanName.add("#{item." + noIdField.getFieldName() + "}");
            }

        }
        xmlContentBean.setInsertValues(values);
        xmlContentBean.setInsertValuesWithNoBeanName(valuesWithNoBeanName);
    }

    private String getIdType(List<FieldBean> fields) {
        if (null == fields) {
            return "";
        }
        List<FieldBean> fieldList = fields.stream().filter(e -> "id".equalsIgnoreCase(e.getFieldName())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(fieldList)){
            FieldBean id = fieldList.get(0);
            return JavaBasicTypeEnum.getTypeByBasicType(id.getType()).getBasicType();
        }
        return "";
    }
}
