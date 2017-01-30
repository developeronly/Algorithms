package com.example.chapter2.priorityqueues;

import com.example.chapter2.SortFactory;
import com.example.chapter2.Sorter;
import com.example.models.Student;
import org.junit.Test;

import static com.example.chapter2.SortType.HEAP_SORT;
import static org.junit.Assert.assertTrue;

public class HeapSortTest {

    private Sorter initialise() {
        return SortFactory.create(HEAP_SORT);
    }

    @Test
    public void checkSortedOrder() {
        Integer[] input = new Integer[7];
        input[0] = 3;
        input[1] = 2;
        input[2] = 12;
        input[3] = 1;
        input[4] = 90;
        input[5] = 11;
        input[6] = 9;
        initialise().sort(input);
        assertTrue(initialise().isSorted(input));
    }

    @Test
    public void checkSortedOrderForGeneric() {
        Student[] input = new Student[3];
        input[0] = new Student(3, "A", "B");
        input[1] = new Student(2, "C", "D");
        input[2] = new Student(1, "E", "F");
        initialise().sort(input);
        assertTrue(initialise().isSorted(input));
    }

    @Test
    public void alreadySortedArray() {
        Integer[] input = new Integer[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        initialise().sort(input);
        assertTrue(initialise().isSorted(input));
    }

    @Test
    public void emptyArray() {
        Integer[] input = new Integer[0];
        initialise().sort(input);
        assertTrue(initialise().isSorted(input));
    }

}
