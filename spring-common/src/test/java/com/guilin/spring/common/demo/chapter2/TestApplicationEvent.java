package com.guilin.spring.common.demo.chapter2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guilin on 2017/3/3.
 * ApplicationEvent事件
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventConfig.class)
public class TestApplicationEvent {

    @Autowired
    private EmailPublisher emailPublisher;

    @Test
    public void test1() {
        emailPublisher.publish("abc@163.com", "Hello Lili!");
    }
}
