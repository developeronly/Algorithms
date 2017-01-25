package com.example.chapter2.mergesort;

public class TopDownMergeSort extends MergeSort {

    @Override
    public void sort(Comparable[] input) {
        setAuxiliary(new Comparable[input.length]);
        mergeSort(input, 0, input.length - 1);
    }

    private void mergeSort(Comparable[] input, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;

        mergeSort(input, low, mid);
        mergeSort(input, mid + 1, high);
        mergeSortedArrays(input, low, mid, high);
    }

}
