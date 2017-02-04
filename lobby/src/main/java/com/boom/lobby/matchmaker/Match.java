package com.boom.lobby.matchmaker;

import java.net.URL;


public class Match {
    private final Id id;
    private final URL url;

    public Match(Id id, URL url) {
        this.id = id;
        this.url = url;
    }
}
