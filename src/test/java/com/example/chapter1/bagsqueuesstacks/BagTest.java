package com.example.chapter1.bagsqueuesstacks;

import com.example.models.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BagTest {

    private Bag initializeBag() {
        return new Bag();
    }

    @Test
    public void initBag() {
        int initialSize = 0;
        assertEquals(initialSize, initializeBag().size());
        assertTrue(initializeBag().isEmpty());
    }

    @Test
    public void addElementInsideBag() {
        Bag<String> bag = initializeBag();
        bag.add("Element.");
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }

    @Test
    public void addGenericElementInsideBag() {
        Bag<Student> bag = initializeBag();
        bag.add(new Student(1, "Suraj", "Pune"));
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }

    @Test
    public void iteratingStack() {
        Bag bag = initializeBag();
        List<String> elementToBeAdded = new ArrayList<>();
        elementToBeAdded.add("First element.");
        elementToBeAdded.add("Second element.");
        elementToBeAdded.add("Third element.");
        elementToBeAdded.forEach(bag::add);
        //Just printing Bag
        for (String element : ((Bag<String>) bag)) { //Checkout typecasting inside foreach look.
            System.out.println(element);
        }

        Iterator<String> iterator = bag.iterator();
        List<String> elementToBeRetrieved = new ArrayList<>();
        while (iterator.hasNext()) {
            elementToBeRetrieved.add(iterator.next());
        }

        Collections.reverse(elementToBeRetrieved);
        assertThat(elementToBeRetrieved, is(elementToBeAdded));
    }

}
