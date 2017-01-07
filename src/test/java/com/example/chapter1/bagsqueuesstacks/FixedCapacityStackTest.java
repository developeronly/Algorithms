package com.example.chapter1.bagsqueuesstacks;

import com.example.models.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FixedCapacityStackTest {

    private static final int SMALL_STACK_SIZE = 10;

    private FixedCapacityStack initStackWithCapacity(int capacity) {
        return new FixedCapacityStack(capacity);
    }

    @Test
    public void initStack() {
        int initialStackSize = 0;
        assertEquals("Check initial size.", initialStackSize, initStackWithCapacity(SMALL_STACK_SIZE).size());
        assertTrue("Check initially created stack is empty.", initStackWithCapacity(SMALL_STACK_SIZE).isEmpty());
    }

    @Test
    public void pushStringInsideStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        stack.push("First String");
        assertEquals("Check size after adding one string element.", 1, stack.size());
    }

    @Test
    public void pushAndPopStringFromStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        String pushedElement = "First String";
        stack.push(pushedElement);
        String poppedElement = (String) stack.pop();
        assertEquals("Check popped element with pushed one..", pushedElement, poppedElement);
    }

    @Test
    public void pushAndPopStudentFromStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        Student pushedStudent = new Student(1, "suraj", "pune");
        stack.push(pushedStudent);
        Student poppedStudent = (Student) stack.pop();
        assertEquals("Check popped element with pushed one..", pushedStudent, poppedStudent);
    }

    @Test(expected = IllegalStateException.class)
    public void popElementFromEmptyStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        stack.pop();
    }

    @Test(expected = IllegalStateException.class)
    public void initializingStackWithZeroCapacity() {
        FixedCapacityStack stack = initStackWithCapacity(0);
    }

    @Test
    public void resizingStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        int newCapacity = 20;
        stack.resize(newCapacity);
        assertEquals("Check newly resized stack.", newCapacity, stack.currentCapacity());
    }

    @Test
    public void checkResizingOnFullStack() {
        int initialCapacity = 1;
        FixedCapacityStack stack = initStackWithCapacity(initialCapacity);
        stack.push("First element.");
        stack.push("Second element.");
        assertEquals("Check newly resized stack.", (initialCapacity * stack.getResizingFactor()), stack
                .currentCapacity());
    }

    @Test
    public void checkResizingOnEmptyStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        while (stack.size() <= stack.currentCapacity() / 4)
            stack.push("Element.");
        stack.pop();
        assertEquals("Check newly resized stack.",
                (SMALL_STACK_SIZE / stack.getResizingFactor()), stack.currentCapacity());
    }

}
