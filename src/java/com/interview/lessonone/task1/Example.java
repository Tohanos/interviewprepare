package com.interview.lessonone.task1;

public class Example {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .firstName("Vasya")
                .middleName("Ivanovich")
                .lastName("Pupkin")
                .phone("+79099099009")
                .country("Russia")
                .address("Koshkina 9")
                .age(25)
                .gender("Male")
                .build();
        System.out.println(person);
    }
}
