package com.guilin.spring.aop.demo.chapter3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guilin on 2017/3/2.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Client.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCounter() throws IndexOutOfBoundsException {
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);
        compactDisc.playTrack(4);
        compactDisc.playTrack(5);
        compactDisc.playTrack(6);
        compactDisc.playTrack(7);

        Assert.assertEquals(1, trackCounter.getPlayCount(1));
        Assert.assertEquals(1, trackCounter.getPlayCount(2));
        Assert.assertEquals(3, trackCounter.getPlayCount(3));
        Assert.assertEquals(1, trackCounter.getPlayCount(4));
        Assert.assertEquals(1, trackCounter.getPlayCount(5));
        Assert.assertEquals(0, trackCounter.getPlayCount(6));
        Assert.assertEquals(0, trackCounter.getPlayCount(7));
    }
}
