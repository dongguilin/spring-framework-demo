package com.guilin.spring.aop.demo.chapter1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guilin on 2017/3/2.
 */
@Aspect
public class SurroundAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurroundAdvice.class);

    @Pointcut("execution(* com.guilin.spring.aop.demo.common.Performance.perform(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            long start = System.currentTimeMillis();//开始时间
            LOGGER.info("Silencing cell phones");
            LOGGER.info("Taking seats");
            joinPoint.proceed();
            LOGGER.info("CLAP CLAP CLAP!!!");
            long end = System.currentTimeMillis();//结束时间
            LOGGER.info("演出持续时间：{}毫秒", end - start);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            LOGGER.info("Demanding a refund");
        }
    }
}
