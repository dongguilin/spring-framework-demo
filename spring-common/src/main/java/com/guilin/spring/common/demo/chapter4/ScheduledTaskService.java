package com.guilin.spring.common.demo.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by guilin on 2017/3/3.
 */
@Service
public class ScheduledTaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(fixedRate = 2000)
    public void fixRateExecution() {
        Random random = new Random();
        try {
            int a = random.nextInt(10);
            Thread.sleep(a * 1000);
            LOGGER.info("reportCurrentTime {} 任务耗时{}秒 {}", Thread.currentThread().getName(), a, dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void fixDelayExecution() {
        Random random = new Random();
        try {
            int a = random.nextInt(10);
            Thread.sleep(a * 1000);
            LOGGER.info("fixRateExecution {} 任务耗时{}秒 {}", Thread.currentThread().getName(), a, dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        LOGGER.info("在指定时间 {} 执行", dateFormat.format(new Date()));
    }
}
