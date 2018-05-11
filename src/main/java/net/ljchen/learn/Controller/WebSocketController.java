package net.ljchen.learn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/a")
    @SendTo("/topic/messages")
    public String sendDemoA(String message) {

        System.out.println("get message (" + message + ") from client!");
        System.out.println("send messages to all subscribers!");

        String time = new SimpleDateFormat("HH:mm").format(new Date());

        return time;
    }

    @MessageMapping("/chat/b")
    public void sendDemoB(String message) {

        System.out.println("get message (" + message + ") from client!");
        System.out.println("send messages to all subscribers!");

        String time = new SimpleDateFormat("HH:mm").format(new Date());
        simpMessagingTemplate.convertAndSend("/topic/server/push", "---------server push msg to client----------");

        return;
    }
}
