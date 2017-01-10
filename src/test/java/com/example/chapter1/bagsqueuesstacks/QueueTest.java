package com.example.chapter1.bagsqueuesstacks;

import com.example.models.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    private Queue initializeQueue() {
        return new Queue();
    }

    @Test
    public void checkInitialSizeOfQueue() {
        int initialSize = 0;
        assertEquals(initialSize, initializeQueue().size());
        assertTrue(initializeQueue().isEmpty());
    }

    @Test
    public void enqueueElement() {
        Queue<String> queue = initializeQueue();
        queue.enqueue("Element");
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueueAndDequeueElement() {
        Queue<String> queue = initializeQueue();
        String expectedElement = "First Element";
        queue.enqueue(expectedElement);
        String actualElement = queue.dequeue();
        assertEquals(expectedElement, actualElement);
    }

    @Test
    public void enqueueAndDequeueGenericElement() {
        Queue<Student> queue = initializeQueue();
        Student expectedElement = new Student(1, "Suraj", "Pune");
        queue.enqueue(expectedElement);
        Student actualElement = queue.dequeue();
        assertEquals(expectedElement, actualElement);
    }

    @Test(expected = IllegalStateException.class)
    public void popElementFromEmptyQueue() {
        Queue queue = initializeQueue();
        queue.dequeue();
    }

    @Test
    public void iteratingQueue() {
        Queue queue = initializeQueue();
        List<String> elementToBeQueued = new ArrayList<>();
        elementToBeQueued.add("First element.");
        elementToBeQueued.add("Second element.");
        elementToBeQueued.add("Third element.");
        elementToBeQueued.forEach(queue::enqueue);
        //Just printing queue
        for (String element : ((Queue<String>) queue)) { //Checkout typecasting inside foreach look.
            System.out.println(element);
        }

        Iterator<String> iterator = queue.iterator();
        List<String> elementToBeDequeue = new ArrayList<>();
        while (iterator.hasNext()) {
            elementToBeDequeue.add(iterator.next());
        }

        assertThat(elementToBeDequeue, is(elementToBeQueued));
    }

}
