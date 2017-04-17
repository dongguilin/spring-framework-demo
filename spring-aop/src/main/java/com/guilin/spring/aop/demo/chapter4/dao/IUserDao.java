package com.guilin.spring.aop.demo.chapter4.dao;

import com.guilin.spring.aop.demo.chapter4.domain.User;

import java.util.Collection;

/**
 * Created by guilin on 2017/4/17.
 */
public interface IUserDao {
    boolean add(User user);

    Collection<User> queryAll();

    User query(String name, int age);

    boolean deleteAll();
}
