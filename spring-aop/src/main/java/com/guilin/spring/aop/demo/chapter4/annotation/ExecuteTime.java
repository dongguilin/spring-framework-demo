package com.guilin.spring.aop.demo.chapter4.annotation;

import java.lang.annotation.*;

/**
 * Created by guilin on 2017/4/17.
 * 录方法执行时长
 */
@Target(ElementType.METHOD)//注解用在方法上，用于描述方法
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface ExecuteTime {

    //调用时长阈值，默认为0，单位为毫秒，运行时长超过threshold毫秒时打印运行时长日志
    int threshold() default 0;

}
