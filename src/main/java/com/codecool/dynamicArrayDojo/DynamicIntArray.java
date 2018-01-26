package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] data;
    private int size = 0;
    private int capacity = 2;


    public DynamicIntArray() {
        data = new int[capacity];
    }

    public DynamicIntArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public int get(int index) {
        return data[index];
    }

    private void resizeIfFull() {

        if (size < data.length) {
            return;
        }
        int[] bigger = new int[2 * data.length];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }

    public void add(int value) {
        resizeIfFull();
        data[size] = value;
        size++;
    }

    public void insert(int index, int value) {

        resizeIfFull();
        for (int from = size - 1; from >= index; from--) {
            data[from + 1] = data[from];
        }
        data[index] = value;
        size++;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int from = index; from < size - 1; from++) {
            data[from - 1] = data[from];
        }
        size--;
    }

    public String toString() {

        String toString = "";
        for (int i = 0; i < size; i++) {
            toString += " " + data[i];
        }
        return toString;
    }



}
