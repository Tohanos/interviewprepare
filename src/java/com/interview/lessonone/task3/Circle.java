package com.interview.lessonone.task3;

public class Circle extends Shape implements Resizable{
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Shape move(double dx, double dy) {
        return new Circle(center.move(dx, dy), radius);
    }

    @Override
    public Shape resize(double factor) {
        return new Circle(center, radius * factor);
    }

}
