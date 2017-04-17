package com.guilin.spring.aop.demo.chapter4.service.impl;

import com.guilin.spring.aop.demo.chapter4.annotation.ExecuteTime;
import com.guilin.spring.aop.demo.chapter4.annotation.InvokeLog;
import com.guilin.spring.aop.demo.chapter4.dao.IUserDao;
import com.guilin.spring.aop.demo.chapter4.domain.User;
import com.guilin.spring.aop.demo.chapter4.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by guilin on 2017/4/17.
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @InvokeLog(value = "增加用户", printResult = false)
    @ExecuteTime(threshold = 10)
    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @InvokeLog(value = "查询所有用户service", retMsg = "输出结果:{}")
    @Override
    public Collection<User> queryAll() {
        return userDao.queryAll();
    }

    @InvokeLog("根据名字和年龄")
    @Override
    public User query(String name, int age) {
        LOG.info("根据名字[{}]和年龄[{}]查询用户", name, age);
        return userDao.query(name, age);
    }

    @Override
    public boolean deleteAll() {
        return userDao.deleteAll();
    }

}
