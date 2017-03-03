package com.guilin.spring.aop.demo.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guilin on 2017/3/2.
 */
@Component
public class BlankDisc implements CompactDisc {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlankDisc.class);

    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}", title, artist);
        for (String track : tracks) {
            LOGGER.info("-Track: {}", track);
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        LOGGER.info("Playing {} by {}, -Track:{}", title, artist, tracks.get(--trackNumber));
    }
}
