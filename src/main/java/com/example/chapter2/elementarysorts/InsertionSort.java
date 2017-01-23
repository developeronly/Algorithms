package com.example.chapter2.elementarysorts;

import com.example.chapter2.Sorter;

public class InsertionSort extends Sorter {

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        for (int index = 1; index < length; index++) {
            for (int innerIndex = index; innerIndex > 0 && isLess(input[innerIndex], input[innerIndex - 1]);
                 innerIndex--) {
                exchange(input, innerIndex, innerIndex - 1);
            }
        }
    }

}
