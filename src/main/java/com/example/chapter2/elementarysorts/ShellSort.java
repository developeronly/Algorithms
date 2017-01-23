package com.example.chapter2.elementarysorts;

import com.example.chapter2.Sorter;

public class ShellSort extends Sorter {

    private static final int FACTOR = 3;

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        int hTh = 1;
        while (hTh < length / FACTOR) hTh = hTh * FACTOR + 1;
        while (hTh >= 1) {
            for (int index = hTh; index < length; index++) {
                for (int innerIndex = index; innerIndex >= hTh && isLess(input[innerIndex], input[innerIndex - hTh]);
                     innerIndex -= hTh) {
                    exchange(input, innerIndex, innerIndex - hTh);
                }
            }
            hTh = hTh / FACTOR;
        }
    }

}
