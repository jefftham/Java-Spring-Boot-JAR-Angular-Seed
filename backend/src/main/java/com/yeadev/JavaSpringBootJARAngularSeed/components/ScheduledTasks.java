package com.yeadev.JavaSpringBootJARAngularSeed.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

// a spring task scheduler that using spring annotation
// ref: https://docs.spring.io/spring/docs/5.0.4.RELEASE/spring-framework-reference/integration.html#scheduling-task-scheduler

@Slf4j
@Component
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // @Scheduled()  annotation can not use with WebSocketConfigurer
    // @Scheduled(fixedRate=1000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}