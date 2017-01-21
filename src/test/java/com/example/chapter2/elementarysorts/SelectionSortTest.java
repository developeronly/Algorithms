package com.example.chapter2.elementarysorts;

import com.example.models.Student;
import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    private Sorter initialise() {
        return SortFactory.create(SortType.SELECTION_SORT);
    }

    @Test
    public void checkSortedOrder() {
        Integer[] input = new Integer[3];
        input[0] = 3;
        input[1] = 2;
        input[2] = 1;
        initialise().sort(input);
        Assert.assertTrue(initialise().isSorted(input));
    }

    @Test
    public void checkSortedOrderForGeneric() {
        Student[] input = new Student[3];
        input[0] = new Student(3, "A", "B");
        input[1] = new Student(2, "C", "D");
        input[2] = new Student(1, "E", "F");
        initialise().sort(input);
        Assert.assertTrue(initialise().isSorted(input));
    }

    @Test
    public void alreadySortedArray() {
        Integer[] input = new Integer[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        initialise().sort(input);
        Assert.assertTrue(initialise().isSorted(input));
    }

    @Test
    public void emptyArray() {
        Integer[] input = new Integer[0];
        initialise().sort(input);
        Assert.assertTrue(initialise().isSorted(input));
    }

}
