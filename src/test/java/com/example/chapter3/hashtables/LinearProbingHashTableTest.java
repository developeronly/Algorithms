package com.example.chapter3.hashtables;

import com.example.models.Student;
import org.junit.Test;

import static com.example.chapter3.hashtables.HashSymbolTableType.LINEAR_PROBING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinearProbingHashTableTest {

    public HashSymbolTable constructDummyStringTree() {
        HashSymbolTable hashSymbolTable = HashSymbolTableFactory.get(LINEAR_PROBING);
        hashSymbolTable.put("s", "S");
        hashSymbolTable.put("e", "E");
        hashSymbolTable.put("a", "A");
        hashSymbolTable.put("r", "R");
        hashSymbolTable.put("c", "C");
        hashSymbolTable.put("h", "H");
        hashSymbolTable.put("e", "E");
        hashSymbolTable.put("x", "X");
        hashSymbolTable.put("a", "A");
        hashSymbolTable.put("m", "M");
        hashSymbolTable.put("p", "P");
        hashSymbolTable.put("l", "L");
        hashSymbolTable.put("e", "E");
        return hashSymbolTable;
    }

    @Test
    public void init() {
        HashSymbolTable<String, String> hashSymbolTable = HashSymbolTableFactory.get(LINEAR_PROBING);
        assertTrue(hashSymbolTable.isEmpty());
        assertEquals(0, hashSymbolTable.size());
        hashSymbolTable = constructDummyStringTree();
        assertFalse(hashSymbolTable.isEmpty());
    }

    @Test
    public void putString() {
        HashSymbolTable<Integer, String> hashSymbolTable = HashSymbolTableFactory.get(LINEAR_PROBING);
        hashSymbolTable.put(0, "Suraj");
        assertEquals(1, hashSymbolTable.size());
        hashSymbolTable.put(1, "Raj");
        assertEquals(2, hashSymbolTable.size());
        hashSymbolTable.put(2, "Mahesh");
        assertEquals(3, hashSymbolTable.size());
    }

    @Test
    public void getString() {
        HashSymbolTable<String, String> hashSymbolTable = constructDummyStringTree();
        assertEquals("S", hashSymbolTable.get("s"));
        assertEquals("X", hashSymbolTable.get("x"));
        assertEquals(null, hashSymbolTable.get("Unexpected"));
    }

    @Test
    public void putAndGetForGeneric() {
        HashSymbolTable<Student, String> hashSymbolTable = HashSymbolTableFactory.get(LINEAR_PROBING);
        Student firstStudent = new Student(1, "Suraj", "Pune");
        hashSymbolTable.put(firstStudent, "Suraj");
        assertEquals(hashSymbolTable.get(firstStudent), "Suraj");
        Student secondStudent = new Student(2, "Raj", "Satara");
        hashSymbolTable.put(secondStudent, "Raj");
        assertEquals(hashSymbolTable.get(secondStudent), "Raj");
        Student thirdStudent = new Student(3, "Mahesh", "Mumbai");
        hashSymbolTable.put(thirdStudent, "Mahesh");
        assertEquals(hashSymbolTable.get(thirdStudent), "Mahesh");
        Student fourthStudent = new Student(3, "Akshay", "Karad");
        hashSymbolTable.put(fourthStudent, "Akshay");
        assertEquals(hashSymbolTable.get(fourthStudent), "Akshay");
    }

    @Test
    public void contains() {
        HashSymbolTable<String, String> hashSymbolTable = constructDummyStringTree();
        assertTrue(hashSymbolTable.contains("a"));
        assertFalse(hashSymbolTable.contains("z"));
    }

    @Test
    public void delete() {
        HashSymbolTable<String, String> hashSymbolTable = constructDummyStringTree();
        hashSymbolTable.delete("e");
        assertEquals(null, hashSymbolTable.get("e"));
    }

    @Test
    public void putGetDelete() {
        //Initialize empty hash table
        HashSymbolTable<String, String> hashSymbolTable = HashSymbolTableFactory.get(LINEAR_PROBING);
        assertTrue(hashSymbolTable.isEmpty());
        assertEquals(0, hashSymbolTable.size());

        //Put some values.
        hashSymbolTable.put("s", "S");
        assertFalse(hashSymbolTable.isEmpty());
        assertEquals(1, hashSymbolTable.size());
        hashSymbolTable.put("e", "E");
        assertFalse(hashSymbolTable.isEmpty());
        assertEquals(2, hashSymbolTable.size());
        hashSymbolTable.put("z", "Z");
        assertFalse(hashSymbolTable.isEmpty());
        assertEquals(3, hashSymbolTable.size());

        //Retrieve some values
        String firstElement = hashSymbolTable.get("s");
        assertEquals("S", firstElement);
        assertFalse(hashSymbolTable.isEmpty());
        assertEquals(3, hashSymbolTable.size());

        //Delete some values
        hashSymbolTable.delete("s");
        assertFalse(hashSymbolTable.contains("s"));
        assertEquals(2, hashSymbolTable.size());
        hashSymbolTable.delete("z");
        hashSymbolTable.delete("e");

        assertTrue(hashSymbolTable.isEmpty());
        assertEquals(0, hashSymbolTable.size());
    }

    @Test
    public void keys() {
        HashSymbolTable<String, String> hashSymbolTable = constructDummyStringTree();
        System.out.println();
        hashSymbolTable.keys().forEach(key -> System.out.print(" " + key));
    }

}
