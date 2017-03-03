package com.guilin.spring.common.demo.chapter5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guilin on 2017/3/3.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConditionConfig.class)
public class TestCondition {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        ListService listService = context.getBean(ListService.class);
        System.out.println(listService.showListCmd());
        ;
    }
}
