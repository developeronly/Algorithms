package com.example.chapter1.bagsqueuesstacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleFixedCapacityStackOfStringsTest {

    private static final int SMALL_STACK_SIZE = 10;

    private FixedCapacityStackOfStrings initStackWithCapacity(int capacity) {
        return new FixedCapacityStackOfStrings(capacity);
    }

    @Test
    public void initStack() {
        int initialStackSize = 0;
        assertEquals("Check initial size.", initialStackSize, initStackWithCapacity(SMALL_STACK_SIZE).size());
        assertTrue("Check initially created stack is empty.", initStackWithCapacity(SMALL_STACK_SIZE).isEmpty());
    }

    @Test
    public void pushStringInsideStack() {
        FixedCapacityStackOfStrings stack = initStackWithCapacity(SMALL_STACK_SIZE);
        stack.push("First String");
        assertEquals("Check size after adding one string element.", 1, stack.size());
    }

    @Test
    public void pushAndPopStringFromStack() {
        FixedCapacityStackOfStrings stack = initStackWithCapacity(SMALL_STACK_SIZE);
        String pushedElement = "First String";
        stack.push(pushedElement);
        String poppedElement = stack.pop();
        assertEquals("Check popped element with pushed one..", pushedElement, poppedElement);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void popElementFromEmptyStack() {
        FixedCapacityStackOfStrings stack = initStackWithCapacity(SMALL_STACK_SIZE);
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pushAnElementOnFilledStack() {
        FixedCapacityStackOfStrings stack = initStackWithCapacity(SMALL_STACK_SIZE);
        for (int index = 0; index < SMALL_STACK_SIZE; index++) stack.push("" + index);
        stack.push("Should throw an exception.");

    }

}
