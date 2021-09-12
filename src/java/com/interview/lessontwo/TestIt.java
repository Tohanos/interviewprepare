package com.interview.lessontwo;

public class TestIt {
    public static void main(String[] args) {
        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>();
        simpleArrayList.add(123);
        simpleArrayList.add(234);
        for (int i = 0; i < 20; i++) {
            simpleArrayList.add(i);
        }
        for (int i = 0; i < simpleArrayList.sizeOf(); i++) {
            System.out.println(simpleArrayList.get(i));
        }

        SimpleList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.put(123);
        simpleList.put(456);
        simpleList.put(789, 1);


        for (int i = 0; i < simpleList.sizeOf(); i++) {
            System.out.println(simpleList.get(i));
        }

    }
}
