package com.yeadev.JavaSpringBootJARAngularSeed.webSocketHandlers;

import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    // keep all active sessions
    List sessions = new CopyOnWriteArrayList<>();

    // inner class to map json object
    @Data
    class Message {
        private String type;
        private String payload;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException{
        // wrap the received json object into map
        log.info("receive: "+message);
        Map data = new Gson().fromJson(message.getPayload(),Map.class);

        // see what type of message
        final String type = (String) data.get("type");

        switch (type){
            case "name":
                // payload from frontend
                String username = (String) data.get("payload");

                log.info("receive name: "+ username);

                // build return message
                Message ret = new Message();
                ret.setType("name");
                ret.setPayload("Hi, "+username);

                // build message to json
                String retJson = new Gson().toJson(ret);

                session.sendMessage(new TextMessage(retJson));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        log.info("added new WebSocket session.");
        sessions.add(session);
    }

}
