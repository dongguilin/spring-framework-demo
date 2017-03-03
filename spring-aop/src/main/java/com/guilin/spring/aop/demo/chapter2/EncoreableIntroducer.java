package com.guilin.spring.aop.demo.chapter2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by guilin on 2017/3/2.
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.guilin.spring.aop.demo.common.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
