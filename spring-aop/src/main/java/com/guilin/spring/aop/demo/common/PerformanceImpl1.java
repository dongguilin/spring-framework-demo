package com.guilin.spring.aop.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by guilin on 2017/3/2.
 */
@Component
public class PerformanceImpl1 implements Performance {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceImpl1.class);

    @Override
    public void perform() {
        LOGGER.info("invoke perform 1");
    }
}
