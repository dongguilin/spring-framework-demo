package com.guilin.spring.aop.demo.chapter2;

import com.guilin.spring.aop.demo.common.Audience;
import com.guilin.spring.aop.demo.common.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by guilin on 2017/3/2.
 * 通过DeclareParents注解引入新功能
 */
@SpringBootApplication(scanBasePackages = {"com.guilin.spring.aop.demo.common", "com.guilin.spring.aop.demo.chapter2"})
@EnableAspectJAutoProxy
public class Client {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Client.class, args);
        Performance performance1 = context.getBean("performanceImpl1", Performance.class);
        performance1.perform();
        Encoreable encoreable = (Encoreable) performance1;
        encoreable.performEncore();
        System.out.println("");

        Performance performance2 = context.getBean("performanceImpl2", Performance.class);
        performance2.perform();
        encoreable = (Encoreable) performance2;
        encoreable.performEncore();
    }
}
