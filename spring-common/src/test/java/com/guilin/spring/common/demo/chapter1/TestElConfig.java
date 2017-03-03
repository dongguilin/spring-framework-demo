package com.guilin.spring.common.demo.chapter1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by guilin on 2017/3/3.
 * Spring EL
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ElConfig.class)
public class TestElConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestElConfig.class);

    @Autowired
    private ElConfig elConfig;

    @Test
    public void test1() throws IOException {
        LOGGER.info(elConfig.getNormal());
        LOGGER.info(elConfig.getOsName());
        LOGGER.info(elConfig.getRandomNumber() + "");
        LOGGER.info(elConfig.getFromAnother());
        LOGGER.info(elConfig.getTestFile().getFile().getName());
        LOGGER.info(elConfig.getTestUrl().getURL().toString());
        LOGGER.info(elConfig.getBookName());
        LOGGER.info(elConfig.getEnvironment().toString());

    }
}
