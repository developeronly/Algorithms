package com.example.chapter2.mergesort;

import com.example.chapter2.SortType;

public class MergeSortFactory {

    public static MergeSort create(SortType sortType) {
        MergeSort sorter;
        switch (sortType) {
            case TOP_DOWN_MERGE_SORT:
                sorter = new TopDownMergeSort();
                break;
            case BOTTOM_UP_MERGE_SORT:
                sorter = new BottomUpMergeSort();
                break;
            default:
                throw new IllegalStateException("Invalid Merge Sort Type.");
        }
        return sorter;
    }

}
