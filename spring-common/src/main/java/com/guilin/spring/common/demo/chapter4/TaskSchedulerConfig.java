package com.guilin.spring.common.demo.chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by guilin on 2017/3/3.
 * 计划任务通过配置@EnableScheduling、@Scheduled来提供支持，@Scheduled支持cron、fixDelay、fixRate
 * 注意：配置Scheduled的任务在一个单线程中串行执行，任务一个任务阻塞都会影响其他任务，要配合Async异步执行
 */
@Configuration
@ComponentScan
@EnableScheduling
public class TaskSchedulerConfig {

    public static void main(String[] args) {
        SpringApplication.run(TaskSchedulerConfig.class, args);
    }
}
