package com.coder.enhance.service.impl;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.MapperConfigBean;
import com.coder.enhance.bean.builder.MapperConfigBeanBuilder;
import com.coder.enhance.service.GenCodeService;
import com.coder.enhance.util.FileUtils;
import com.coder.enhance.util.VelocityUtil;

/**
 * @author jeffy
 * @date 2019-02-05
 **/
public class MapperJavaGenCodeServiceImpl implements GenCodeService {

    @Override
    public void check(ClassBean baseBean, Configuration configuration) {
        return;
    }

    @Override
    public void genCode(ClassBean classBean, Configuration configuration) {
        ClassBean baseBean = new MapperConfigBeanBuilder(classBean, configuration).build();
        MapperConfigBean mapper = (MapperConfigBean) baseBean;
        String mapperString = VelocityUtil.render(classBean, "dao", "mapper.java.vm", mapper);
        FileUtils.createFile(configuration.getCharset(),
                FileUtils.getFileExtension(classBean.getBeanName(), configuration.getMapperSuffix(), ".java"),
                mapperString,
                configuration.getEntityPath());
    }
}
