package com.coder.enhance.service;

import com.coder.enhance.bean.BaseConfigBean;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public interface GenCodeService {

    /**
     * check parameter before gen code
     *
     * @param baseBean
     */
    void check(BaseConfigBean baseBean);

    /**
     * gen code
     *
     * @param baseBean
     */
    void genCode(BaseConfigBean baseBean);

}
