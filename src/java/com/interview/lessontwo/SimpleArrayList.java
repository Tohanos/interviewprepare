package com.interview.lessontwo;

public class SimpleArrayList<T> implements SimpleList<T> {
    private final int DEFAULT_SIZE = 16;
    private Object[] contents;
    private int size = 0;

    public SimpleArrayList() {
        contents = new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T t) {
        if (size + 1 > contents.length) {
            incrementSize();
        }
        contents[size] = t;
        size++;
    }

    private void incrementSize() {
        Object[] newContents = new Object[contents.length + DEFAULT_SIZE];
        System.arraycopy(contents, 0, newContents, 0, contents.length);
        contents = newContents;
    }

    @Override
    public void delete(T t) {
        for (int i = 0; i < size; i++) {
            if (contents[i].equals(t)) {
                remove(i);
                break;
            }
        }
    }

    private void remove(int index) {
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(contents, index + 1, contents, index, newSize - index);
        }
        contents[newSize] = null;
        size = newSize;
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T) contents[index];
    }

    @Override
    public void put(T t) {
        add(t);
    }

    @Override
    public void put(T t, int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        contents[index] = t;
    }

    @Override
    public int sizeOf() {
        return size;
    }
}
