package com.interview.lessontwo;

public interface SimpleList<T> {
    void add(T t);
    void delete(T t);
    T get(int index);
    void put(T t);
    void put(T t, int index);
    int sizeOf();
}
