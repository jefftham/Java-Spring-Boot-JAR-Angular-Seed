package com.yeadev.JavaSpringBootJARAngularSeed.util.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

// https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/util-timer.html

@Slf4j
@Component
public class FixedDelayScheduler {

    public void start(TimerTask task, int delay, int period){
        log.info("FixedDelayScheduler.start() is running.");
        log.info("Main thread: " + Thread.currentThread());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, delay, period);
    }

}
