package com.coder.enhance.bean.builder;

import com.coder.enhance.bean.ClassBean;
import com.coder.enhance.exception.AutoCoderException;

public interface BeanBuilder {

    ClassBean build() throws AutoCoderException;
}
