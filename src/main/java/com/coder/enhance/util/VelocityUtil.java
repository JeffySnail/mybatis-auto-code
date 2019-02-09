package com.coder.enhance.util;

import com.coder.enhance.bean.ClassBean;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;

import java.io.StringWriter;
import java.util.Properties;

/**
 * @author jeffy
 * @date 2019-02-02
 **/
public class VelocityUtil {

    private static VelocityEngine ve = null;
    private static Properties props = new Properties();

    static {
        props.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    }

    public static void init(ClassBean classBean) {
        //定义字符集
        props.setProperty(Velocity.ENCODING_DEFAULT, classBean.getCharset());
        props.setProperty(Velocity.OUTPUT_ENCODING, classBean.getCharset());
        if (null == ve) {
            ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM, new NullLogChute());
            ve.init(props);
        }
    }


    public static final String render(ClassBean config, String prefix, String templateFile, Object parameter) {
        init(config);
        Template template = ve.getTemplate(templateFile);
        VelocityContext context = new VelocityContext();
        context.put(prefix, parameter);

        StringWriter w = new StringWriter();
        template.merge(context, w);
        return w.toString();
    }
}
