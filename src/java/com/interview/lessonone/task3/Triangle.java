package com.interview.lessonone.task3;

public class Triangle extends Shape implements Resizable, Rotatable{
    private final Point corner;
    private final double side;
    private final double angleLeft;
    private final double angleRight;
    private final double rotation;

    public Triangle(Point corner, double side, double angleLeft, double angleRight, double rotation) {
        this.corner = corner;
        this.side = side;
        this.angleLeft = angleLeft;
        this.angleRight = angleRight;
        this.rotation = rotation;
    }

    @Override
    public Shape move(double dx, double dy) {
        return new Triangle(corner.move(dx, dy), side, angleLeft, angleRight, rotation);
    }

    @Override
    public Shape resize(double factor) {
        return new Triangle(corner, side * factor, angleLeft, angleRight, rotation);
    }

    @Override
    public Shape rotate(double angle) {
        return new Triangle(corner, side, angleLeft, angleRight, rotation + angle);
    }
}
