package com.boom.lobby.matchmaker;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class Id {
    private final UUID id;

    private Id() {
        this.id = UUID.randomUUID();
    }

    public static Id make() {
        return new Id();
    }
}
