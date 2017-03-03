package com.guilin.spring.common.demo.chapter2;

import org.springframework.context.ApplicationEvent;

/**
 * Created by guilin on 2017/3/3.
 */
public class EmailListEvent extends ApplicationEvent {
    private String address;
    private String text;

    public EmailListEvent(Object source) {
        super(source);
    }

    public EmailListEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
