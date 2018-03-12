package com.yeadev.JavaSpringBootJARAngularSeed.configurations;

import com.yeadev.JavaSpringBootJARAngularSeed.webSocketHandlers.WebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// websocket without stomp and sockjs
// ref: http://www.devglan.com/spring-boot/spring-websocket-integration-example-without-stomp

@Slf4j
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // added end point,
        // eg. ws://localhost:8080/ws

        // added WebSocketHandler to /ws
        registry.addHandler(new WebSocketHandler(),"/ws");
        log.info("added handler for WebSocket.");
    }



}
