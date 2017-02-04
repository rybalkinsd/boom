package com.boom.ingame.util;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class V {
    private static final double TOLERANCE = 0.01;
    public static final V ZERO = V.of(0, 0);

    private final double x, y;

    private V(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static V of(double x,  double y) {
        return new V(x, y);
    }

    public V move(double dx, double dy) {
        return V.of(x + dx, y + dy);
    }
    public V move(V v) {
        return V.of(x + v.x, y + v.y);
    }

    public V times(long v) {
        return V.of(x * v, y * v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        V v = (V) o;

        return Math.abs(x - v.x) < TOLERANCE
                && Math.abs(y - v.y) < TOLERANCE;
    }

    @Override
    public int hashCode() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}