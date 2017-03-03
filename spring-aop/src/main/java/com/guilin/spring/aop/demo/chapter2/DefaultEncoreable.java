package com.guilin.spring.aop.demo.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guilin on 2017/3/2.
 */
public class DefaultEncoreable implements Encoreable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultEncoreable.class);

    @Override
    public void performEncore() {
        LOGGER.info("This is a default performEncore!");
    }
}
