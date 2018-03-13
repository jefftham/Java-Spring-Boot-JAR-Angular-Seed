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
    private List<Object> sessions = new CopyOnWriteArrayList<>();

    // inner class to map json object
    @Data
    class Message {
        private String type;
        private String payload;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException{
        // wrap the received json object into map
        // log.info("receive: "+message);
        Map data = new Gson().fromJson(message.getPayload(),Map.class);

        // see what type of message
        final String type = getValueFromMessage(message,"type");

        switch (type){
            case "name":
                // payload from frontend
                String username = getValueFromMessage(message,"payload");

                log.info("receive name: "+ username);

                // build message to json
                TextMessage retJson = setJson("name", "Hi, "+username);

                session.sendMessage(retJson);
        }
    }

    // get value from received message from frontend
    private String getValueFromMessage(TextMessage message, String key){
        Map data = new Gson().fromJson(message.getPayload(),Map.class);
        return (String) data.get(key);
    }

    // build return json to frontend
    private TextMessage setJson (String type, String payload){
        Message ret = new Message();
        ret.setType(type);
        ret.setPayload(payload);

        // build message to json
        return new TextMessage(new Gson().toJson(ret));
    }

    // wrap any object to json
    public String toJson(Object obj){
        return new Gson().toJson(obj);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        log.info("added new WebSocket session.");
        sessions.add(session);
    }

}
