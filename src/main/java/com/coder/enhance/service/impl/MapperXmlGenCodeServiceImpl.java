package com.coder.enhance.service.impl;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.XmlConfigConfigBean;
import com.coder.enhance.bean.builder.XmlConfigBeanBuilder;
import com.coder.enhance.exception.AutoCoderException;
import com.coder.enhance.service.GenCodeService;
import com.coder.enhance.util.FileUtils;
import com.coder.enhance.util.VelocityUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jeffy
 * @date 2019-02-04
 **/
public class MapperXmlGenCodeServiceImpl implements GenCodeService {
    @Override
    public void check(ClassBean baseBean, Configuration configuration) {
        //first check for class bean must has id addTime updateTime properties
        ClassBean xmlBaseBean = new XmlConfigBeanBuilder(baseBean, configuration).build();
        XmlConfigConfigBean xml = (XmlConfigConfigBean) xmlBaseBean;
        if (null == xml || CollectionUtils.isEmpty(xml.getFields())) {
            throw AutoCoderException.paramException("bean contains no field");
        }
        List<String> fieldNames = xml.getFields().stream().map(e -> e.getFieldName()).collect(Collectors.toList());
        if (!fieldNames.containsAll(configuration.MUST_HAS_FIELDS)) {
            throw AutoCoderException.paramException("Bean must has id ,addTime ,updateTime property");
        }

    }

    @Override
    public void genCode(ClassBean baseBean, Configuration configuration) {
        ClassBean xml = new XmlConfigBeanBuilder(baseBean, configuration).build();
        XmlConfigConfigBean tempXml = (XmlConfigConfigBean) xml;
        String mapperString = VelocityUtil.render(baseBean, "xml", "mapper.xml.vm", tempXml);
//        String formatXml = FileUtils.xmlFormat(mapperString, configuration.getCharset());
        FileUtils.createFile(configuration.getCharset(),
                FileUtils.getFileExtension(baseBean.getBeanName(), configuration.getMapperSuffix(), ".xml"),
                mapperString,
                configuration.getEntityPath());
    }
}
