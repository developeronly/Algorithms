package com.example.chapter1.bagsqueuesstacks;

import com.example.models.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResizingArrayStackTest {

    private ResizingArrayStack initializeStack() {
        return new ResizingArrayStack();
    }

    @Test
    public void initStack() {
        int initialStackSize = 0;
        assertEquals("Check initial size.", initialStackSize, initializeStack().size());
        assertTrue("Check initially created stack is empty.", initializeStack().isEmpty());
    }

    @Test
    public void pushStringInsideStack() {
        ResizingArrayStack stack = initializeStack();
        stack.push("First String");
        assertEquals("Check size after adding one string element.", 1, stack.size());
    }

    @Test
    public void pushAndPopStringFromStack() {
        ResizingArrayStack stack = initializeStack();
        String pushedElement = "First String";
        stack.push(pushedElement);
        String poppedElement = (String) stack.pop();
        assertEquals("Check popped element with pushed one..", pushedElement, poppedElement);
    }

    @Test
    public void pushAndPopStudentFromStack() {
        ResizingArrayStack stack = initializeStack();
        Student pushedStudent = new Student(1, "suraj", "pune");
        stack.push(pushedStudent);
        Student poppedStudent = (Student) stack.pop();
        assertEquals("Check popped element with pushed one..", pushedStudent, poppedStudent);
    }

    @Test(expected = IllegalStateException.class)
    public void popElementFromEmptyStack() {
        ResizingArrayStack stack = initializeStack();
        stack.pop();
    }

    @Test
    public void resizingStack() {
        ResizingArrayStack stack = initializeStack();
        int newCapacity = 20;
        stack.resize(newCapacity);
        assertEquals("Check newly resized stack.", newCapacity, stack.currentCapacity());
    }

    @Test
    public void checkResizingOnFullStack() {
        int initialCapacity = 1;
        ResizingArrayStack stack = initializeStack();
        stack.push("First element.");
        stack.push("Second element.");
        assertEquals("Check newly resized stack.", (initialCapacity * stack.getResizingFactor()), stack
                .currentCapacity());
    }

    @Test
    public void iteratingStack() {
        ResizingArrayStack stack = initializeStack();
        List<String> elementToBePushed = new ArrayList<>();
        elementToBePushed.add("First element.");
        elementToBePushed.add("Second element.");
        elementToBePushed.add("Third element.");
        elementToBePushed.forEach(stack::push);
        //Just printing stack
        for (String element : ((ResizingArrayStack<String>) stack)) { //Checkout typecasting inside foreach look.
            System.out.println(element);
        }

        Iterator<String> iterator = stack.iterator();
        List<String> elementToBePopped = new ArrayList<>();
        while (iterator.hasNext()) {
            elementToBePopped.add(iterator.next());
        }

        //Converting lists to arrays.
        Collections.reverse(elementToBePopped);
        String[] expected = new String[elementToBePopped.size()];
        String[] actual = new String[elementToBePushed.size()];
        elementToBePopped.toArray(expected);
        elementToBePushed.toArray(actual);
        assertArrayEquals("Check stack LIFO order", expected, actual);

    }

}
