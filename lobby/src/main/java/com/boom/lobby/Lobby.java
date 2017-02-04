package com.boom.lobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Lobby {
    public static void main(String[] args) {
        SpringApplication.run(Lobby.class, args);
    }
}
