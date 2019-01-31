package com.coder.enhance.dialog;

import com.coder.enhance.service.GenCodeService;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author jeffy
 * @date 2019-01-30
 **/
public class ConfigDialog extends DialogWrapper {
    private AnActionEvent anActionEvent;

    public ConfigDialog(AnActionEvent anActionEvent) {
        super(anActionEvent.getProject());
        this.anActionEvent = anActionEvent;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();

        ServiceLoader<GenCodeService> services = ServiceLoader.load(GenCodeService.class);
        Iterator<GenCodeService> it = services.iterator();
        while (it.hasNext()) {
            GenCodeService service = it.next();
//            service.check();
        }
        while (it.hasNext()){
            GenCodeService service = it.next();
//            service.genCode();
        }
    }
}
