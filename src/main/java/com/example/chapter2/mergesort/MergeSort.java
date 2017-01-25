package com.example.chapter2.mergesort;

import com.example.chapter2.Sorter;

public abstract class MergeSort extends Sorter {

    private Comparable[] auxiliary;

    protected void mergeSortedArrays(Comparable[] input, int low, int mid, int high) {
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

    protected Comparable[] getAuxiliary() {
        return auxiliary;
    }

    protected void setAuxiliary(Comparable[] auxiliary) {
        this.auxiliary = auxiliary;
    }
}
