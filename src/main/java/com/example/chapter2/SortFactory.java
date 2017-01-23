package com.example.chapter2;

import com.example.chapter2.elementarysorts.InsertionSort;
import com.example.chapter2.elementarysorts.SelectionSort;
import com.example.chapter2.elementarysorts.ShellSort;

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
            default:
                throw new IllegalStateException("Invalid Sort Type.");
        }
        return sorter;
    }

}
