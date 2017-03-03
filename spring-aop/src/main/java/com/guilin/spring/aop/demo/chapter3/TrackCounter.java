package com.guilin.spring.aop.demo.chapter3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guilin on 2017/3/2.
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* com.guilin.spring.aop.demo.chapter3.CompactDisc.playTrack(int )) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

//    @After("trackPlayed(trackNumber)")
//    public void countTrack(int trackNumber) {
//        int currentCount = getPlayCount(trackNumber);
//        trackCounts.put(trackNumber, currentCount + 1);
//    }

    @Around("trackPlayed(trackNumber)")
    public void countTrack2(ProceedingJoinPoint joinPoint, int trackNumber) {
        try {
            joinPoint.proceed();
            int currentCount = getPlayCount(trackNumber);
            trackCounts.put(trackNumber, currentCount + 1);
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            System.out.println(trackNumber);
        }
    }


    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
