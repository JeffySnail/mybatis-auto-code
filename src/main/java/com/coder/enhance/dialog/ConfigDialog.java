package com.coder.enhance.dialog;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;
import com.coder.enhance.bean.FieldBean;
import com.coder.enhance.exception.AutoCoderException;
import com.coder.enhance.service.GenCodeService;
import com.coder.enhance.ui.AutoCoderConfigForm;
import com.coder.enhance.util.ClassHelper;
import com.coder.enhance.util.CommentUtil;
import com.coder.enhance.util.PathUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jeffy
 * @date 2019-01-30
 **/
public class ConfigDialog extends DialogWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigDialog.class);
    private AnActionEvent anActionEvent;
    private AutoCoderConfigForm form;

    public ConfigDialog(AnActionEvent anActionEvent) {
        super(anActionEvent.getProject());
        this.anActionEvent = anActionEvent;
        form = new AutoCoderConfigForm(anActionEvent.getProject(), anActionEvent);
        setTitle("Auto-Coder Config");
        setOKButtonText("OK");
        setSize(800, 500);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return form.getMainForm();
    }

    @Override
    protected void doOKAction() {
        try {
            super.doOKAction();
            Project project = anActionEvent.getProject();
            String classpath = PathUtil.getClassPath(anActionEvent);
            String entityPath = PathUtil.getEntityPath(anActionEvent);
            Configuration configuration = new Configuration(project, form,
                    classpath, entityPath);

            ClassBean classBean = this.baseConfigBeanWrapper(classpath, entityPath, configuration);
            Thread.currentThread().setContextClassLoader(GenCodeService.class.getClassLoader());
            ServiceLoader<GenCodeService> services = ServiceLoader.load(GenCodeService.class);
            Iterator<GenCodeService> checkIterator = services.iterator();
            while (checkIterator.hasNext()) {
                GenCodeService service = checkIterator.next();
                service.check(classBean, configuration);
            }
            Iterator<GenCodeService> genCodeServiceIterator = services.iterator();
            while (genCodeServiceIterator.hasNext()) {
                GenCodeService service = genCodeServiceIterator.next();
                service.genCode(classBean, configuration);
            }
        } catch (Exception ex) {
            LOGGER.error("generate code error ", ex);
            Messages.showErrorDialog(ex.getMessage(), "generate code error");
        }
    }


    private ClassBean baseConfigBeanWrapper(String classpath, String entityPath, Configuration config) throws AutoCoderException {
        Project project = anActionEvent.getProject();
        final DataContext dataContext = anActionEvent.getDataContext();
        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        Optional.ofNullable(editor).orElseThrow(() -> AutoCoderException.innerException("editor is null"));
        final PsiFile psiFile = PsiUtilBase.getPsiFileInEditor(editor, project);
        Optional.ofNullable(psiFile).orElseThrow(() -> AutoCoderException.innerException("psi file is null"));
        final PsiClass targetClass = ClassHelper.getTargetClass(editor, psiFile);
        PsiField[] fields = targetClass.getAllFields();
        if (null == fields || fields.length <= 0) {
            throw AutoCoderException.paramException("class " + targetClass.getName() + "has no field");
        }
        List<FieldBean> fieldList = Arrays.stream(fields).map(field -> {
            FieldBean bean = new FieldBean();
            bean.setType(field.getType().getPresentableText());
            bean.setComment(CommentUtil.formatText(null != field.getDocComment() ? field.getDocComment().getText() : ""));
            bean.setFieldName(field.getName());
            return bean;
        }).collect(Collectors.toList());
        ClassBean classBean = new ClassBean();
        classBean.setBeanName(targetClass.getName());
        classBean.setComment(CommentUtil.formatText(null != targetClass.getDocComment() ? targetClass.getDocComment().getText() : ""));
        classBean.setFields(fieldList);
        classBean.setClasspath(classpath);
        classBean.setEntityPath(entityPath);
        classBean.setCharset(config.getCharset());
        classBean.setUnCapitalizeBeanName(StringUtils.uncapitalize(targetClass.getName()));
        return classBean;

    }
}
