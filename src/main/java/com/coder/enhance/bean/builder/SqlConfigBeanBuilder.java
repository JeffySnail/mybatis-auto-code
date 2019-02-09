package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.SqlConfigBean;
import com.coder.enhance.enums.JavaBasicTypeEnum;
import com.coder.enhance.exception.AutoCoderException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jeffy
 * @date 2019-02-03
 **/
public class SqlConfigBeanBuilder implements BeanBuilder {

    private ClassBean classBean;

    private Configuration configuration;

    public SqlConfigBeanBuilder(ClassBean classBean, Configuration configuration) {
        this.classBean = classBean;
        this.configuration = configuration;
    }

    @Override
    public ClassBean build() throws AutoCoderException {
        SqlConfigBean sqlConfigBean = new SqlConfigBean();
        List<String> fields = classBean.getFields().stream().map(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.getFieldName());
            stringBuilder.append(" ");
            stringBuilder.append(JavaBasicTypeEnum.getTypeMappingConfigByType(e.getType(), configuration));
            stringBuilder.append(" COMMENT ").append(e.getComment());
            stringBuilder.append(",");
            return stringBuilder.toString();
        }).collect(Collectors.toList());
        sqlConfigBean.setFieldStrList(fields);
        sqlConfigBean.setTableComment(classBean.getComment());
        sqlConfigBean.setTableName(classBean.getBeanName());
        return sqlConfigBean;
    }
}
