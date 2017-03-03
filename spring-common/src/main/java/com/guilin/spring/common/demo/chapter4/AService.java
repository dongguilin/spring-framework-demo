package com.guilin.spring.common.demo.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by guilin on 2017/3/3.
 */
@Service
public class AService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AService.class);

    @Scheduled(fixedDelay = 2000)
    public void methodA() {
        LOGGER.info("{} Aservice A", Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 3000)
    public void methodB() {
        LOGGER.info("{} Aservice B", Thread.currentThread().getName());
    }

}
