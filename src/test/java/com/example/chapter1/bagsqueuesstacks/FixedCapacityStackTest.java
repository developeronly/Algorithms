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
        assertEquals("Check size after adding one string element.",
                1, stack.size());
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

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void popElementFromEmptyStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pushAnElementOnFilledStack() {
        FixedCapacityStack stack = initStackWithCapacity(SMALL_STACK_SIZE);
        for (int index = 0; index < SMALL_STACK_SIZE; index++) stack.push("" + index);
        stack.push("Should throw an exception.");

    }

}
