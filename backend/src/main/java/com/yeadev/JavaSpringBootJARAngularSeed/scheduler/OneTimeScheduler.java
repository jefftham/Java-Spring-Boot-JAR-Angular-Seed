
package com.yeadev.JavaSpringBootJARAngularSeed.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/util-timer.html

@Slf4j
@Component
public class OneTimeScheduler {

    // Schedules the specified task for execution after the specified delay.
    public void start(TimerTask task, long delay){
        log.info("OneTimeScheduler.start() is running.");
        log.info("Main thread: " + Thread.currentThread());
        Timer timer = new Timer();
        timer.schedule(task, delay);
    }

    // Schedules the specified task for execution at the specified time.  If
    // the time is in the past, the task is scheduled for immediate execution.
    public void start(TimerTask task, Date delay){
        log.info("OneTimeScheduler.start() is running.");
        log.info("Main thread: " + Thread.currentThread());
        Timer timer = new Timer();
        timer.schedule(task, delay);
    }

}
