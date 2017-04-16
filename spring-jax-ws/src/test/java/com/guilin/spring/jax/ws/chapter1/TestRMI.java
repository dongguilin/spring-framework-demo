package com.guilin.spring.jax.ws.chapter1;

import com.alibaba.fastjson.JSON;
import com.guilin.spring.jax.ws.chapter1.domain.Spitter;
import com.guilin.spring.jax.ws.chapter1.domain.Spittle;
import com.guilin.spring.jax.ws.chapter1.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by guilin on 2017/4/16.
 * <p>
 * RMI缺点：<br>
 * 1.RMI很难穿越防火墙，这是因为RMI使用任意端口来交互，这是防火墙通常所不允许的<br>
 * 2.RMI是基于Java的，客户端和服务端必须都是用Java开发<br>
 * 3.RMI使用Java的序列化机制，所以通过网络传输的对象类型必须要保证在调用两端的Java运行时中是完全相同的版本
 * </p>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RMIConfig.class)
public class TestRMI {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void contextLoads() {
    }

    //TODO  Caused by: java.rmi.ConnectException: Connection refused to host: localhost; nested exception is:
    @Test
    public void testSpitterService() {
        List<Spitter> list = spitterService.getRecentSpittles(2);
        System.out.println(JSON.toJSONString(list));
        spitterService.saveSpittle(new Spittle(1l, new Spitter(), "hello", new Date()));
    }
}
