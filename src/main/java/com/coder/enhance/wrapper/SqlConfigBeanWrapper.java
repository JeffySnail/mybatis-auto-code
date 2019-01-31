package com.coder.enhance.wrapper;

import com.coder.enhance.bean.BaseConfigBean;
import com.coder.enhance.bean.ConfigDialogBean;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class SqlConfigBeanWrapper implements BeanWrapper {

    private ConfigDialogBean dialogBean;

    public SqlConfigBeanWrapper(ConfigDialogBean dialogBean) {
        this.dialogBean = dialogBean;
    }

    @Override
    public BaseConfigBean wrapper() {
        return null;
    }
}
