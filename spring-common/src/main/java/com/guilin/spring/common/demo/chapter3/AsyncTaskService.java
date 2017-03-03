package com.guilin.spring.common.demo.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guilin on 2017/3/3.
 */
@Service
public class AsyncTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTaskService.class);

    private AtomicInteger counter = new AtomicInteger();

    @Async
    public void executeAsyncTask(Integer i) {
        counter.getAndAdd(1);
        LOGGER.info("执行异步任务:{}", i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        LOGGER.info("执行异步任务+1:{}", i+1);
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
