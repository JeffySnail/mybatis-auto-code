package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.MapperConfigBean;
import com.coder.enhance.exception.AutoCoderException;
import com.coder.enhance.util.PathUtil;

/**
 * @author jeffy
 * @date 2019-02-05
 **/
public class MapperConfigBeanBuilder implements BeanBuilder {
    private ClassBean classBean;

    private Configuration configuration;

    public MapperConfigBeanBuilder(ClassBean classBean, Configuration configuration) {
        this.classBean = classBean;
        this.configuration = configuration;
    }

    @Override
    public ClassBean build() throws AutoCoderException {
        MapperConfigBean mapperConfigBean = new MapperConfigBean();
        mapperConfigBean.setInterfaceName(classBean.getBeanName() + configuration.getMapperSuffix());
        mapperConfigBean.setPackagePath(PathUtil.getRelativePath(configuration.getMapperPath()));
        mapperConfigBean.setBeanName(classBean.getBeanName());
        mapperConfigBean.setComment(classBean.getComment());
        mapperConfigBean.setUnCapitalizeBeanName(classBean.getUnCapitalizeBeanName());
        mapperConfigBean.setFields(classBean.getFields());
        mapperConfigBean.setCharset(configuration.getCharset());
        mapperConfigBean.setClasspath(configuration.getClasspath());
        mapperConfigBean.setEntityPath(configuration.getEntityPath());
        return mapperConfigBean;
    }
}
