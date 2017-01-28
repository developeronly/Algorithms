package com.example.chapter2.priorityqueues;

import com.example.chapter2.Sorter;

public class HeapSort extends Sorter {

    private boolean isLess(Comparable[] input, int firstElement, int secondElement) {
        return input[firstElement - 1].compareTo(input[secondElement - 1]) < 0;
    }

    public void exchange(Comparable[] input, int i, int j) {
        super.exchange(input, i - 1, j - 1);
    }

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        for (int index = length / 2; index >= 1; index--)
            sink(input, index, length);
        while (length > 1) {
            exchange(input, 1, length--);
            sink(input, 1, length);
        }
    }

    private void sink(Comparable[] input, int index, int length) {
        while (2 * index <= length) {
            int j = 2 * index;
            if (j < length && isLess(input, j, j + 1)) j++;
            if (!isLess(input, index, j)) break;
            exchange(input, index, j);
            index = j;
        }
    }

}
