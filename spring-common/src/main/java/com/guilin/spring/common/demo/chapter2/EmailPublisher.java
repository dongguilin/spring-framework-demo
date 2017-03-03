package com.guilin.spring.common.demo.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by guilin on 2017/3/3.
 */
@Component
public class EmailPublisher {
    @Autowired
    private ApplicationContext context;

    public void publish(String address, String msg) {
        context.publishEvent(new EmailListEvent(this, address, msg));
    }
}
