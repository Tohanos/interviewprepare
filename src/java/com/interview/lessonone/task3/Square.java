package com.interview.lessonone.task3;

public class Square extends Shape implements Resizable, Rotatable{
    private final Point leftUpperCorner;
    private final double sideLength;
    private final double angle;

    public Square(Point leftUpperCorner, double sideLength, double angle) {
        this.leftUpperCorner = leftUpperCorner;
        this.sideLength = sideLength;
        this.angle = angle;
    }

    @Override
    public Shape move(double dx, double dy) {
        return new Square(leftUpperCorner.move(dx, dy), sideLength, angle);
    }

    @Override
    public Shape resize(double factor) {
        return new Square(leftUpperCorner, sideLength * factor, angle);
    }

    @Override
    public Shape rotate(double angle) {
        return new Square(leftUpperCorner, sideLength, this.angle + angle);
    }
}
