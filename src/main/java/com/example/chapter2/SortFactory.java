package com.example.chapter2;

import com.example.chapter2.elementarysorts.InsertionSort;
import com.example.chapter2.elementarysorts.SelectionSort;
import com.example.chapter2.elementarysorts.ShellSort;
import com.example.chapter2.mergesort.MergeSortFactory;
import com.example.chapter2.priorityqueues.HeapSort;
import com.example.chapter2.quicksort.QuickSort;

public class SortFactory {

    public static Sorter create(SortType sortType) {
        Sorter sorter;
        switch (sortType) {
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
            case BOTTOM_UP_MERGE_SORT:
                sorter = MergeSortFactory.create(sortType);
                break;
            case QUICK_SORT:
                sorter = new QuickSort();
                break;
            case HEAP_SORT:
                sorter = new HeapSort();
                break;
            default:
                throw new IllegalStateException("Invalid Sort Type.");
        }
        return sorter;
    }

}
