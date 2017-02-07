package com.example.chapter3;

import com.example.models.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SequentialSearchTest {

    @Test
    public void putStringElement() {
        SequentialSearch<String, String> sequentialSearch = new SequentialSearch();
        sequentialSearch.put("first element", "Suraj");
        assertFalse(sequentialSearch.isEmpty());
        assertEquals(1, sequentialSearch.size());
    }

    @Test
    public void getStringElement() {
        SequentialSearch<String, String> sequentialSearch = new SequentialSearch();
        sequentialSearch.put("first element", "Suraj");
        sequentialSearch.put("second element", "Raj");
        String firstValue = sequentialSearch.get("first element");
        String secondValue = sequentialSearch.get("second element");
        assertEquals("Suraj", firstValue);
        assertEquals("Raj", secondValue);
    }

    @Test(expected = IllegalStateException.class)
    public void getElementIfEmpty() {
        SequentialSearch<String, String> sequentialSearch = new SequentialSearch();
        sequentialSearch.get("second element");
    }

    @Test
    public void getElementForInvalidKey() {
        SequentialSearch<String, String> sequentialSearch = new SequentialSearch();
        sequentialSearch.put("first element", "Suraj");
        String value = sequentialSearch.get("second element");
        assertEquals(null, value);

    }

    @Test
    public void getAndPutForGenericValues() {
        SequentialSearch<Student, String> sequentialSearch = new SequentialSearch();
        Student firstStudent = new Student(1, "Suraj", "Pune");
        Student secondStudent = new Student(2, "Raj", "Satara");
        sequentialSearch.put(firstStudent, "Engineer");
        sequentialSearch.put(secondStudent, "Architect");
        assertEquals("Engineer", sequentialSearch.get(firstStudent));
        assertEquals("Architect", sequentialSearch.get(secondStudent));
    }

}
