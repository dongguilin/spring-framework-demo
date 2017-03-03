package com.guilin.spring.aop.demo.chapter3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilin on 2017/3/2.
 * 为通知传递参数
 */
@SpringBootApplication(scanBasePackages = {"com.guilin.spring.aop.demo.chapter3"})
@EnableAspectJAutoProxy
public class Client {

    @Bean
    public CompactDisc compactDisc() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        blankDisc.setArtist("The Beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        blankDisc.setTracks(tracks);
        return blankDisc;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
