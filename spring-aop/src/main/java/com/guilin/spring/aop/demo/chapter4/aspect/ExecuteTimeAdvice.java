package com.guilin.spring.aop.demo.chapter4.aspect;

import com.guilin.spring.aop.demo.chapter4.annotation.ExecuteTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guilin on 2017/4/11.
 * 记录方法执行时长
 */
@Aspect
public class ExecuteTimeAdvice {

    @Pointcut("(execution(* com.guilin.spring.aop.demo.chapter4.service..*.*(..))||" +
            "execution(* com.guilin.spring.aop.demo.chapter4.dao..*.*(..)))&&@annotation(executeTime)")
    public void pointCut(ExecuteTime executeTime) {
    }

    @Around("pointCut(executeTime)")
    public Object logInvokeTime(ProceedingJoinPoint joinPoint, ExecuteTime executeTime) throws Throwable {
        long start = System.currentTimeMillis();//开始时间
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();//结束时间
            long duration = end - start;
            if (duration >= executeTime.threshold()) {
                LOGGER.info("执行时长：{}毫秒", duration);
            }
        }
    }

}
