package com.example.chapter2.elementarysorts;

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
            default:
                throw new IllegalStateException("Invalid Sort Type.");
        }
        return sorter;
    }

}
