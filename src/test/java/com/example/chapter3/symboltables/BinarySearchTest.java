package com.example.chapter3.symboltables;

import com.example.models.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Test
    public void putStringElement() {
        BinarySearch<String, String> binarySearch = new BinarySearch(1);
        binarySearch.put("first element", "Suraj");
        assertFalse(binarySearch.isEmpty());
        assertEquals(1, binarySearch.size());
    }

    @Test
    public void getStringElement() {
        BinarySearch<String, String> binarySearch = new BinarySearch(2);
        binarySearch.put("first element", "Suraj");
        binarySearch.put("second element", "Raj");
        String firstValue = binarySearch.get("first element");
        String secondValue = binarySearch.get("second element");
        assertEquals("Suraj", firstValue);
        assertEquals("Raj", secondValue);
    }

    @Test(expected = IllegalStateException.class)
    public void getElementIfEmpty() {
        BinarySearch<String, String> binarySearch = new BinarySearch(2);
        binarySearch.get("second element");
    }

    @Test
    public void getElementForInvalidKey() {
        BinarySearch<String, String> binarySearch = new BinarySearch(2);
        binarySearch.put("first element", "Suraj");
        String value = binarySearch.get("second element");
        assertEquals(null, value);
    }

    @Test
    public void getAndPutForGenericValues() {
        BinarySearch<Student, String> binarySearch = new BinarySearch(2);
        Student firstStudent = new Student(1, "Suraj", "Pune");
        Student secondStudent = new Student(2, "Raj", "Satara");
        binarySearch.put(firstStudent, "Engineer");
        binarySearch.put(secondStudent, "Architect");
        assertEquals("Engineer", binarySearch.get(firstStudent));
        assertEquals("Architect", binarySearch.get(secondStudent));
    }

    @Test
    public void getKeys() {
        BinarySearch<String, String> binarySearch = new BinarySearch(2);
        binarySearch.put("first element", "Suraj");
        binarySearch.put("second element", "Raj");
        binarySearch.keys().forEach(key -> assertTrue(binarySearch.contains(key)));
    }

    @Test
    public void checkExistenceOfKey() {
        BinarySearch<String, String> binarySearch = new BinarySearch(2);
        binarySearch.put("first element", "Suraj");
        assertTrue(binarySearch.contains("first element"));
    }

    @Test
    public void delete() {
        BinarySearch<String, String> binarySearch = new BinarySearch(3);
        binarySearch.put("first element", "Suraj");
        binarySearch.put("second element", "Raj");
        binarySearch.put("third element", "Mahesh");
        binarySearch.delete("second element");
        assertFalse(binarySearch.contains("second element"));
    }

}
