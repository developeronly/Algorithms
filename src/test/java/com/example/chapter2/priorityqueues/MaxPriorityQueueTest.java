package com.example.chapter2.priorityqueues;

import com.example.models.Student;
import org.junit.Test;

import java.util.Arrays;

import static com.example.chapter2.priorityqueues.PriorityQueueType.MAX;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxPriorityQueueTest {

    private PriorityQueue initialise(int size) {
        return PriorityQueueFactory.create(MAX, size);
    }

    @Test
    public void checkDeletingMax() {
        Integer[] input = new Integer[3];
        input[0] = 3;
        input[1] = 2;
        input[2] = 12;
        PriorityQueue<Integer> priorityQueue = initialise(input.length);
        Arrays.asList(input).stream().forEach(element -> priorityQueue.insert(element));
        assertEquals(12, priorityQueue.delete().longValue());
        assertEquals(3, priorityQueue.delete().longValue());
        assertEquals(2, priorityQueue.delete().longValue());
    }

    @Test
    public void checkSortedOrderInMax() {
        Integer[] input = new Integer[7];
        input[0] = 3;
        input[1] = 2;
        input[2] = 12;
        input[3] = 1;
        input[4] = 90;
        input[5] = 11;
        input[6] = 9;
        PriorityQueue<Integer> priorityQueue = initialise(input.length);
        Arrays.asList(input).stream().forEach(element -> priorityQueue.insert(element));
        Comparable[] sortedInput = priorityQueue.sort();
        assertTrue(new Helper().isSortedInMax(sortedInput));

    }

    @Test
    public void checkSortedOrderForGeneric() {
        Student[] input = new Student[3];
        input[0] = new Student(3, "A", "B");
        input[1] = new Student(2, "C", "D");
        input[2] = new Student(1, "E", "F");
        PriorityQueue<Student> priorityQueue = initialise(input.length);
        Arrays.asList(input).stream().forEach(element -> priorityQueue.insert(element));
        Comparable[] sortedInput = priorityQueue.sort();
        assertTrue(new Helper().isSortedInMax(sortedInput));
    }

    @Test
    public void alreadySortedArray() {
        Integer[] input = new Integer[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        PriorityQueue<Integer> priorityQueue = initialise(input.length);
        Arrays.asList(input).stream().forEach(element -> priorityQueue.insert(element));
        Comparable[] sortedInput = priorityQueue.sort();
        assertTrue(new Helper().isSortedInMax(sortedInput));
    }

    @Test
    public void emptyArray() {
        Integer[] input = new Integer[0];
        PriorityQueue<Integer> priorityQueue = initialise(input.length);
        Arrays.asList(input).stream().forEach(element -> priorityQueue.insert(element));
        Comparable[] sortedInput = priorityQueue.sort();
        assertTrue(new Helper().isSortedInMax(sortedInput));
    }

}
