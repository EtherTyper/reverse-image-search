package main;

import java.io.Serializable;

public class Point implements Serializable {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point adding(Point other) {
        return new Point(x + other.x, y + other.y);
    }
}
