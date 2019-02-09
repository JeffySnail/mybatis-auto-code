package com.coder.enhance.service;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.bean.Configuration;

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
    void check(ClassBean baseBean, Configuration configuration);

    /**
     * gen code
     *
     * @param baseBean
     */
    void genCode(ClassBean baseBean, Configuration configuration);

}
