package com.coder.enhance.wrapper;

import com.coder.enhance.bean.BaseConfigBean;
import com.coder.enhance.bean.ConfigDialogBean;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class JunitConfigBeanWrapper implements BeanWrapper {
    private ConfigDialogBean dialogBean;

    public JunitConfigBeanWrapper(ConfigDialogBean dialogBean) {
        this.dialogBean = dialogBean;
    }

    @Override
    public BaseConfigBean wrapper() {
        return null;
    }
}
