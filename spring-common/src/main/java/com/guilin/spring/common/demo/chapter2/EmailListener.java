package com.guilin.spring.common.demo.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by guilin on 2017/3/3.
 */
@Component
public class EmailListener implements ApplicationListener<EmailListEvent> {
    private static final Logger LOGGER= LoggerFactory.getLogger(EmailListener.class);
    @Override
    public void onApplicationEvent(EmailListEvent emailListEvent) {
        LOGGER.info("接收到{}事件",EmailListEvent.class.getSimpleName());
        LOGGER.info("地址：{},内容：{}",emailListEvent.getAddress(),emailListEvent.getText());
    }
}
