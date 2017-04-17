package com.guilin.spring.aop.demo.chapter4.dao.impl;

import com.guilin.spring.aop.demo.chapter4.annotation.ExecuteTime;
import com.guilin.spring.aop.demo.chapter4.annotation.InvokeLog;
import com.guilin.spring.aop.demo.chapter4.dao.IUserDao;
import com.guilin.spring.aop.demo.chapter4.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by guilin on 2017/4/17.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    private Map<String, User> userMap = new HashMap<>();


    @Override
    public boolean add(User user) {
        userMap.put(user.getName() + user.getAge(), user);
        LOG.info("用户数:{}", userMap.size());
        return true;
    }

    @InvokeLog("查询所有用户dao")
    @Override
    public Collection<User> queryAll() {
        return userMap.values();
    }

    @Override
    public User query(String name, int age) {
        return userMap.get(name + age);
    }

    @InvokeLog("删除所有用户dao")
    @ExecuteTime
    @Override
    public boolean deleteAll() {
        try {
            int random = new Random().nextInt(100);
            Thread.sleep(200 + random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("无法连接上数据库");
    }
}
