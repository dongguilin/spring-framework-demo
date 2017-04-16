package com.guilin.spring.jax.ws.chapter1.service;

import com.guilin.spring.jax.ws.chapter1.domain.Spitter;
import com.guilin.spring.jax.ws.chapter1.domain.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilin on 2017/4/16.
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    private static final Logger LOG = LoggerFactory.getLogger(SpitterServiceImpl.class);

    @Override
    public List<Spitter> getRecentSpittles(int count) {
        LOG.info("invoke getRecentSpittles");
        Spitter spitter = new Spitter();
        spitter.setId((long) count);
        spitter.setFullName("张三丰");
        spitter.setUsername("三丰");
        spitter.setEmail("sf@qq.com");
        spitter.setPassword("123456");
        spitter.setUpdateByEmail(true);
        List<Spitter> list = new ArrayList<>(1);
        list.add(spitter);
        return list;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        LOG.info("保存Spittle成功");
    }

}
