package com.coder.enhance.util;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.SyntheticElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nullable;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class ClassHelper {
    @Nullable
    public static final PsiClass getTargetClass(Editor editor, PsiFile file) {
        int offset = editor.getCaretModel().getOffset();
        PsiElement element = file.findElementAt(offset);
        if (element == null) {
            return null;
        }
        final PsiClass target = PsiTreeUtil.getParentOfType(element, PsiClass.class);
        return target instanceof SyntheticElement ? null : target;
    }
}
