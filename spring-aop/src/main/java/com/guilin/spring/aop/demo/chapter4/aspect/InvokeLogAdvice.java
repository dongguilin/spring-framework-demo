package com.guilin.spring.aop.demo.chapter4.aspect;

import com.alibaba.fastjson.JSON;
import com.guilin.spring.aop.demo.chapter4.annotation.InvokeLog;
import com.guilin.spring.aop.demo.chapter4.annotation.ResultLogType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by guilin on 2017/4/17.
 * 方法调用前后、异常及结果返回时记录日志
 */
@Aspect
public class InvokeLogAdvice {

    @Pointcut("(execution(* com.guilin.spring.aop.demo.chapter4.service..*.*(..))" +
            "||execution(* com.guilin.spring.aop.demo.chapter4.dao..*.*(..)))" +
            "&&@annotation(invokeLog)")
    public void pointCut(InvokeLog invokeLog) {
    }

    //前置通知
    @Before("pointCut(invokeLog)")
    public void doBefore(JoinPoint joinPoint, InvokeLog invokeLog) {
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        joinPoint.getSignature().getClass();
        String start = invokeLog.start();
        String value = invokeLog.value();
        LOGGER.info(value + start);
    }

    //后置通知
    @AfterReturning(pointcut = "pointCut(invokeLog)", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, InvokeLog invokeLog, Object returnValue) {
        if (!invokeLog.printResult()) {
            return;
        }

        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String retMsg = invokeLog.retMsg();
        if (returnValue == null) {
            LOGGER.info(retMsg, "");
        }

        ResultLogType resultLogType = invokeLog.resultLogType();
        switch (resultLogType) {
            case json:
                LOGGER.info(retMsg, JSON.toJSONString(returnValue));
                break;
            case string:
                LOGGER.info(retMsg, returnValue.toString());
                break;
        }
    }

    //最终通知
    @After("pointCut(invokeLog)")
    public void doAfter(JoinPoint joinPoint, InvokeLog invokeLog) {
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String end = invokeLog.end();
        String value = invokeLog.value();
        LOGGER.info(value + end);
    }

    //例外通知
    @AfterThrowing(pointcut = "pointCut(invokeLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e, InvokeLog invokeLog) throws Exception {
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String ex = invokeLog.ex();
        String value = invokeLog.value();
        LOGGER.error(value + ex, e.getMessage());
        throw e;
    }
}
