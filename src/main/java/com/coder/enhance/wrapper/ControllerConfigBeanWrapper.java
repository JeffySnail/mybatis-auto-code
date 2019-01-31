package com.coder.enhance.wrapper;

import com.coder.enhance.bean.BaseConfigBean;
import com.coder.enhance.bean.ConfigDialogBean;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class ControllerConfigBeanWrapper implements BeanWrapper {

    private ConfigDialogBean dialogBean;

    public ControllerConfigBeanWrapper(ConfigDialogBean dialogBean) {
        this.dialogBean = dialogBean;
    }

    @Override
    public BaseConfigBean wrapper() {
        return null;
    }
}
