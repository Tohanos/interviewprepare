package com.interview.lessontwo;

public class SimpleLinkedList<T> implements SimpleList<T> {
    private LinkedItem<T> firstItem;
    private LinkedItem<T> lastItem;
    private int size = 0;

    private static class LinkedItem<T> {
        T item;
        LinkedItem<T> previous;
        LinkedItem<T> next;

        public LinkedItem(T item, LinkedItem<T> previous, LinkedItem<T> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    public SimpleLinkedList() {
    }

    @Override
    public void add(T t) {
        LinkedItem<T> newItem = new LinkedItem<T>(t, lastItem, null);

        if (firstItem == null) {
            firstItem = newItem;
        } else {
            lastItem.next = newItem;
        }
        lastItem = newItem;
        size++;
    }

    @Override
    public void delete(T t) {
        LinkedItem<T> item = firstItem;
        for (int i = 0; i < size; i++) {
            if (item.equals(t)) {
                remove(item);
            }
        }
    }

    private void remove(LinkedItem<T> item) {
        LinkedItem<T> prev = null;
        LinkedItem<T> next = null;

        if (item.previous != null) {
            if (item.next != null) {
                next = item.next;
                prev = item.previous;
                prev.next = next;
                next.previous = prev;
            } else {
                prev = item.previous;
                prev.next = null;
            }
        } else {
            if (item.next != null) {
                next = item.next;
                next.previous = null;
            }
        }
        item = null;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        LinkedItem<T> item = firstItem;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.item;
    }

    @Override
    public void put(T t) {
        add(t);
    }

    @Override
    public void put(T t, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        LinkedItem<T> item = firstItem;
        for (int i = 0; i < index - 1; i++) {
            item = item.next;
        }
        LinkedItem<T> newItem = new LinkedItem<>(t, item, item.next);
        item.next = newItem;
        if (newItem.next != null) {
            newItem.next.previous = newItem;
        }
        size++;
    }

    @Override
    public int sizeOf() {
        return size;
    }
}
