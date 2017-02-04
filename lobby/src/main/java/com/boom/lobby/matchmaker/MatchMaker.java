package com.boom.lobby.matchmaker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class MatchMaker {
    private static final int PLAYERS_IN_MATCH = 4;

    private ConcurrentHashMap<Id, Match> matches;
    private BlockingQueue<Match> matchesQueue;

    private MatchMaker() {
        matches = new ConcurrentHashMap<>();
    }

    public Match join(Id id) throws InterruptedException {
        return matchesQueue.poll(10_000, TimeUnit.MILLISECONDS);
    }

    @Scheduled(fixedRate = 5_000)
    public void make() throws MalformedURLException {
        for (int i = 0; i < PLAYERS_IN_MATCH; i++) {
            Match match = new Match(Id.make(), new URL("http://www.google.com"));
        }
    }

}
