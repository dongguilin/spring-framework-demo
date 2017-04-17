package com.guilin.spring.aop.demo.chapter4.annotation;

import java.lang.annotation.*;

/**
 * Created by guilin on 2017/4/17.
 * 方法调用前后、异常及结果返回时记录日志
 */
@Target(ElementType.METHOD)//注解用在方法上，用于描述方法
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface InvokeLog {
    String value() default "";

    String start() default "接口--调用开始-------------------------->>>";

    String ex() default "接口--调用异常:{}";

    String retMsg() default "执行结果:{}";

    String end() default "接口--调用结束-------------------------->>>";

    //是否打印方法返回结果
    boolean printResult() default true;

    ResultLogType resultLogType() default ResultLogType.json;

}
