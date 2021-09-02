package com.interview.lessonone.task2;

class Lorry extends Car implements Moveable, Stopable{

    public void move(){
        System.out.println("Lorry is moving");
    }

    public void stop(){
        System.out.println("Lorry is stopped");
    }

    @Override
    void open() {
        System.out.println("Lorry is opened");
    }
}

