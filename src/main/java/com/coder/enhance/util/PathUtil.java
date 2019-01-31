package com.coder.enhance.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class PathUtil {

    public static final String getClassPath(AnActionEvent event) {
        if (null == event) {
            return "";
        }
        final DataContext dataContext = event.getDataContext();

        final Project project = event.getProject();
        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        if (null != editor) {
            final PsiFile file = PsiUtilBase.getPsiFileInEditor(editor, project);
            return getRelativePath(file.getVirtualFile().getParent().getPath());
        }
        return "";

    }

    private static final String getEntityPath(AnActionEvent event) {
        if (null == event) {
            return "";
        }
        final DataContext dataContext = event.getDataContext();
        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        if (null != editor) {
            final PsiFile file = PsiUtilBase.getPsiFileInEditor(editor, event.getProject());
            return file.getVirtualFile().getParent().getPath();
        }
        return "";
    }

    public static String getRelativePath(String path) {
        if (null == path) {
            return "";
        }
        if (!path.contains("/src/main/java/")) {
            return path;
        }
        return path.split("/src/main/java/")[1];
    }
}
