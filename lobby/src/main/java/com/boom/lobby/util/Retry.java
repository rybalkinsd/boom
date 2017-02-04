package com.boom.lobby.util;

import java.util.function.Supplier;

/**
 * Created by Sergey Rybalkin on 04/02/17.
 */
public class Retry {
    public static <T> T times(Supplier<T> f, int times) {
        while (times-- > 0) {
            try {
                return f.get();
            } catch (Throwable ignored) { }
        }
        throw new RuntimeException();
    }

    private Retry() {
    }
}
