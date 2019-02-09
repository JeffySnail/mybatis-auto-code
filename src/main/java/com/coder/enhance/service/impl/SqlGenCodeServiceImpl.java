package com.coder.enhance.service.impl;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.SqlConfigBean;
import com.coder.enhance.bean.builder.SqlConfigBeanBuilder;
import com.coder.enhance.service.GenCodeService;
import com.coder.enhance.util.FileUtils;
import com.coder.enhance.util.VelocityUtil;

/**
 * @author jeffy
 * @date 2019-02-06
 **/
public class SqlGenCodeServiceImpl implements GenCodeService {
    @Override
    public void check(ClassBean baseBean, Configuration configuration) {
        return;
    }

    @Override
    public void genCode(ClassBean baseBean, Configuration configuration) {
        ClassBean tempSql = new SqlConfigBeanBuilder(baseBean, configuration).build();
        SqlConfigBean sql = (SqlConfigBean) tempSql;

        String mapperString = VelocityUtil.render(baseBean, "sql", "sql.sql.vm", sql);
        FileUtils.createFile(configuration.getCharset(),
                FileUtils.getFileExtension(baseBean.getBeanName(), configuration.getMapperSuffix(), ".sql"),
                mapperString,
                configuration.getEntityPath());
    }
}
