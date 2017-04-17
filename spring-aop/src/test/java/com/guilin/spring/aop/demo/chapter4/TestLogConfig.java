package com.guilin.spring.aop.demo.chapter4;

import com.guilin.spring.aop.demo.chapter4.domain.User;
import com.guilin.spring.aop.demo.chapter4.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guilin on 2017/4/17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LogConfig.class)
public class TestLogConfig {

    @Autowired
    private IUserService userService;

    @Test
    public void testAdd() {
        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setPhone("18415622548");
        userService.add(user);
        userService.queryAll();
    }

    @Test
    public void testQuery() {
        userService.queryAll();
    }

    @Test
    public void testQueryByNameAndAge() {
        userService.query("张三", 12);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteAll() {
        userService.deleteAll();
    }


}
