package com.guilin.spring.jax.ws.chapter1.domain;

import java.util.Date;

/**
 * Created by guilin on 2017/4/16.
 */
public class Spittle {
    private final Long id;
    private final String text;
    private final Date postedTime;
    private Spitter spitter;

    public Spittle(Long id, Spitter spitter, String text, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.text = text;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }
}
