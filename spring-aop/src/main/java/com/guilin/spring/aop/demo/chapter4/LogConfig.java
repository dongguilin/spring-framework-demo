package com.guilin.spring.aop.demo.chapter4;

import com.guilin.spring.aop.demo.chapter4.aspect.ExecuteTimeAdvice;
import com.guilin.spring.aop.demo.chapter4.aspect.InvokeLogAdvice;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by guilin on 2017/4/17.
 */
@SpringBootApplication(scanBasePackages = {"com.guilin.spring.aop.demo.chapter4"})
@EnableAspectJAutoProxy
public class LogConfig {

    @Bean
    public InvokeLogAdvice invokeLogAdvice() {
        return new InvokeLogAdvice();
    }

    @Bean
    public ExecuteTimeAdvice invokeTimeAdvice() {
        return new ExecuteTimeAdvice();
    }

}
