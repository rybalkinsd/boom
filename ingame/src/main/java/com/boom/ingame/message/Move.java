package com.boom.ingame.message;

import com.boom.ingame.util.V;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Move {
    private final V direction;

    @JsonCreator
    public Move(V direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Move{" +
                "direction=" + direction +
                '}';
    }
}
