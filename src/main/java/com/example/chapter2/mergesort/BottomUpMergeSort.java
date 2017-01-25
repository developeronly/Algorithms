package com.example.chapter2.mergesort;

public class BottomUpMergeSort extends MergeSort {

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        setAuxiliary(new Comparable[length]);
        for (int size = 1; size < length; size = size + size) {
            for (int low = 0; low < length - size; low += size + size) {
                mergeSortedArrays(input, low, low + size - 1, Math.min(low + size + size - 1, length - 1));
            }
        }

    }

}
