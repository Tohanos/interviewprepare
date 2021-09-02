package com.interview.lessonone.task3;

public class Point extends Shape{
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point move(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }
}
