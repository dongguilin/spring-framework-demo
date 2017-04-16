package com.guilin.spring.jax.ws.chapter1.service;

import com.guilin.spring.jax.ws.chapter1.domain.Spitter;
import com.guilin.spring.jax.ws.chapter1.domain.Spittle;

import java.util.List;

/**
 * Created by guilin on 2017/4/16.
 */
public interface SpitterService {
    List<Spitter> getRecentSpittles(int count);

    void saveSpittle(Spittle spittle);
}
