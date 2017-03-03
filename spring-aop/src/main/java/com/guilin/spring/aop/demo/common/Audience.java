package com.guilin.spring.aop.demo.common;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guilin on 2017/3/2.
 */
@Aspect
public class Audience {

    private static final Logger LOGGER = LoggerFactory.getLogger(Audience.class);

    @Pointcut("execution(** com.guilin.spring.aop.demo.common.Performance.perform(..))")
    public void performance() {
    }

    //进场关闭手机
    @Before("performance()")
    public void silenceCellPhones() {
        LOGGER.info("Silencing cell phones");
    }

    //演出前坐在位置上
    @Before("performance()")
    public void takeSeats() {
        LOGGER.info("Taking seats");
    }

    //演出结束鼓掌
    @AfterReturning("performance()")
    public void applause() {
        LOGGER.info("CLAP CLAP CLAP!!!");
    }

    //演出失败要求退款
    @AfterThrowing("performance()")
    public void demandRefund() {
        LOGGER.info("Demanding a refund");
    }
}
