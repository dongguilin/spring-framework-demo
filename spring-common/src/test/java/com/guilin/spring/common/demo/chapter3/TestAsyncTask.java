package com.guilin.spring.common.demo.chapter3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guilin on 2017/3/3.
 * 使用EnableAsync开启对异步任务的支持
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TaskExecutorConfig.class)
public class TestAsyncTask {

    @Autowired
    private AsyncTaskService taskService;

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }
        Assert.assertEquals(10, taskService.getCounter());
    }
}
