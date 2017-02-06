package com.boom.ingame;

import com.boom.ingame.message.Move;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    // Map (Player -> session)
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/move")
    @SendTo("/topic/greetings")
    public String move(Move move) throws Exception {
        System.out.println(move);
        return "Move";
    }

}