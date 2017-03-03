package com.guilin.spring.common.demo.chapter5;

/**
 * Created by guilin on 2017/3/3.
 */
public class LinuxListServiceImpl implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
