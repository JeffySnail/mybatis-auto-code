package com.coder.enhance.util;

import com.coder.enhance.exception.AutoCoderException;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author jeffy
 * @date 2019-02-04
 **/
public class FileUtils {
    public static Path createFile(String charset, String path, String content, String abPath) {

        try {
            String tempPath = abPath + "/" + path;
            if (Files.exists(Paths.get(tempPath))) {
                Files.delete(Paths.get(tempPath));
            }
            Path createPath = Files.createFile(Paths.get(tempPath));
            Files.write(createPath, content.getBytes());
            return createPath;
        } catch (Exception e) {
            throw AutoCoderException.innerException(e.getMessage());
        }
    }

    public static final String read(Path path, String charset) {
        if (null == path) {
            return "";
        }
        try {
            if (Files.exists(path)) {
                return new String(Files.readAllBytes(path), charset);
            }
        } catch (Exception e) {
            throw AutoCoderException.innerException(e.getMessage());
        }
        return "";
    }

    public static final String getFileExtension(String beanName, String suffix, String extension) {
        return new StringBuilder(beanName).append(suffix).append(extension).toString();
    }

    public static final String xmlFormat(String str, String charset) {

        try {
            SAXReader reader = new SAXReader();
            // System.out.println(reader);
            // 注释：创建一个串的字符输入流
            StringReader in = new StringReader(str);
            Document doc = reader.read(in);
            // System.out.println(doc.getRootElement());
            // 注释：创建输出格式
            OutputFormat formater = OutputFormat.createPrettyPrint();
            //formater=OutputFormat.createCompactFormat();
            // 注释：设置xml的输出编码
            formater.setEncoding(charset);
            // 注释：创建输出(目标)
            StringWriter out = new StringWriter();
            // 注释：创建输出流
            XMLWriter writer = new XMLWriter(out, formater);
            // 注释：输出格式化的串到目标中，执行后。格式化后的串保存在out中。
            writer.write(doc);

            writer.close();
            // 注释：返回我们格式化后的结果
            return out.toString();
        } catch (Exception e) {
            throw AutoCoderException.innerException("format xml error");
        }
    }
}
