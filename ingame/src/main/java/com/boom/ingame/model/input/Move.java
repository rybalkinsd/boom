package com.boom.ingame.model.input;

import com.boom.ingame.util.V;
import lombok.ToString;

/**
 * Created by Sergey Rybalkin on 06/02/17.
 */
@ToString
public class Move {
    private final V direction;

    public Move(V direction) {
        this.direction = direction;
    }
}
