package com.coder.enhance.action;


import com.coder.enhance.dialog.ConfigDialog;
import com.coder.enhance.util.ClassHelper;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiUtilBase;
import org.jetbrains.annotations.NotNull;

/**
 * @author jeffy
 */
public class AutoCoderAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        ConfigDialog dialog = new ConfigDialog(event);
        dialog.show();
        dialog.setOKActionEnabled(true);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        super.update(event);
        final Presentation presentation = event.getPresentation();
        final DataContext dataContext = event.getDataContext();

        final Project project = event.getProject();
        if (project == null) {
            presentation.setEnabled(false);
            return;
        }

        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        if (null != editor) {
            final PsiFile file = PsiUtilBase.getPsiFileInEditor(editor, project);
            presentation.setEnabled(file != null && isValidForFile(editor, file));
            return;
        }

        boolean isValid = false;
        final VirtualFile[] files = PlatformDataKeys.VIRTUAL_FILE_ARRAY.getData(dataContext);
        if (null != files) {
            PsiManager psiManager = PsiManager.getInstance(project);
            for (VirtualFile file : files) {
                if (file.isDirectory()) {
                    //directory is valid
                    isValid = true;
                    break;
                }
                if (StdFileTypes.JAVA.equals(file.getFileType())) {
                    PsiJavaFile psiFile = (PsiJavaFile) psiManager.findFile(file);
                    if (psiFile != null) {
                        for (PsiClass psiClass : psiFile.getClasses()) {
                            if (isValidForClass(psiClass)) {
                                isValid = true;
                                break;
                            }

                            for (PsiClass innerClass : psiClass.getAllInnerClasses()) {
                                if (isValidForClass(innerClass)) {
                                    isValid = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (isValid) {
                    break;
                }
            }
        }
        presentation.setEnabled(isValid);
    }

    private boolean isValidForFile(@NotNull Editor editor, @NotNull PsiFile file) {
        if (!(file instanceof PsiJavaFile)) {
            return false;
        }
        if (file instanceof PsiCompiledElement) {
            return false;
        }
        if (!file.isWritable()) {
            return false;
        }

        PsiClass targetClass = ClassHelper.getTargetClass(editor, file);
        return targetClass != null && isValidForClass(targetClass);
    }

    private boolean isValidForClass(@NotNull PsiClass targetClass) {
        if (!targetClass.isInterface()) {
            return true;
        }
        return false;
    }
}
