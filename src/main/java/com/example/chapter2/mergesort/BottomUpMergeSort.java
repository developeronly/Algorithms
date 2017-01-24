package com.example.chapter2.mergesort;

import com.example.chapter2.Sorter;

public class BottomUpMergeSort extends Sorter {

    private Comparable[] auxiliary;

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        auxiliary = new Comparable[length];
        for (int size = 1; size < length; size = size + size) {
            for (int low = 0; low < length - size; low += size + size) {
                mergeSortedArrays(input, low, low + size - 1, Math.min(low + size + size - 1, length - 1));
            }
        }

    }

    private void mergeSortedArrays(Comparable[] input, int low, int mid, int high) {
        int lowIndex = low;
        int midIndex = mid + 1;

        for (int index = low; index <= high; index++) {
            auxiliary[index] = input[index];
        }

        for (int index = low; index <= high; index++) {
            if (lowIndex > mid) input[index] = auxiliary[midIndex++];
            else if (midIndex > high) input[index] = auxiliary[lowIndex++];
            else if (isLess(auxiliary[midIndex], auxiliary[lowIndex])) input[index] = auxiliary[midIndex++];
            else input[index] = auxiliary[lowIndex++];
        }

    }

}
