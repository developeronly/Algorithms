package com.example.chapter2;

import com.example.chapter2.elementarysorts.InsertionSort;
import com.example.chapter2.elementarysorts.SelectionSort;
import com.example.chapter2.elementarysorts.ShellSort;
import com.example.chapter2.mergesort.BottomUpMergeSort;
import com.example.chapter2.mergesort.TopDownMergeSort;

public class SortFactory {

    public static Sorter create(SortType selectionSort) {
        Sorter sorter;
        switch (selectionSort) {
            case SELECTION_SORT:
                sorter = new SelectionSort();
                break;
            case INSERTION_SORT:
                sorter = new InsertionSort();
                break;
            case SHELL_SORT:
                sorter = new ShellSort();
                break;
            case TOP_DOWN_MERGE_SORT:
                sorter = new TopDownMergeSort();
                break;
            case BOTTOM_UP_MERGE_SORT:
                sorter = new BottomUpMergeSort();
                break;
            default:
                throw new IllegalStateException("Invalid Sort Type.");
        }
        return sorter;
    }

}
