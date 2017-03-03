package com.guilin.spring.aop.demo.chapter1;

import com.guilin.spring.aop.demo.common.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by guilin on 2017/3/2.
 * 环绕通知
 */
@SpringBootApplication(scanBasePackages = {"com.guilin.spring.aop.demo.common", "com.guilin.spring.aop.demo.chapter1"})
@EnableAspectJAutoProxy
public class Client {

    @Bean
    public SurroundAdvice surroundAdvice() {
        return new SurroundAdvice();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Client.class, args);
        Performance performance1 = context.getBean("performanceImpl1", Performance.class);
        performance1.perform();
    }
}
