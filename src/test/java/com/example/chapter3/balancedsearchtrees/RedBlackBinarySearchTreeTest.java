package com.example.chapter3.balancedsearchtrees;

import com.example.chapter3.SearchTree;
import com.example.chapter3.TreeFactory;
import com.example.models.Student;
import org.junit.Test;

import static com.example.chapter3.SearchTreeType.BALANCED_SEARCH_TREE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RedBlackBinarySearchTreeTest {

    public SearchTree<String, String> constructDummyStringTree() {
        SearchTree<String, String> redBlackBinarySearchTree = TreeFactory.searchTree(BALANCED_SEARCH_TREE);
        redBlackBinarySearchTree.put("s", "S");
        redBlackBinarySearchTree.put("e", "E");
        redBlackBinarySearchTree.put("a", "A");
        redBlackBinarySearchTree.put("r", "R");
        redBlackBinarySearchTree.put("c", "C");
        redBlackBinarySearchTree.put("h", "H");
        redBlackBinarySearchTree.put("e", "E");
        redBlackBinarySearchTree.put("x", "X");
        redBlackBinarySearchTree.put("a", "A");
        redBlackBinarySearchTree.put("m", "M");
        redBlackBinarySearchTree.put("p", "P");
        redBlackBinarySearchTree.put("l", "L");
        redBlackBinarySearchTree.put("e", "E");
        return redBlackBinarySearchTree;
    }

    @Test
    public void init() {
        SearchTree<String, String> redBlackBinarySearchTree = new RedBlackBinarySearchTree();
        assertEquals(0, redBlackBinarySearchTree.size());
        assertTrue(redBlackBinarySearchTree.isEmpty());
        redBlackBinarySearchTree = constructDummyStringTree();
        assertFalse(redBlackBinarySearchTree.isEmpty());
    }

    @Test
    public void putString() {
        SearchTree<Integer, String> redBlackBinarySearchTree = new RedBlackBinarySearchTree();
        redBlackBinarySearchTree.put(0, "Suraj");
        assertEquals(1, redBlackBinarySearchTree.size());
        redBlackBinarySearchTree.put(1, "Raj");
        assertEquals(2, redBlackBinarySearchTree.size());
        redBlackBinarySearchTree.put(2, "Mahesh");
        assertEquals(3, redBlackBinarySearchTree.size());
    }

    @Test
    public void getString() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("S", redBlackBinarySearchTree.get("s"));
        assertEquals("X", redBlackBinarySearchTree.get("x"));
        assertEquals(null, redBlackBinarySearchTree.get("Unexpected"));
    }

    @Test
    public void putAndGetForGeneric() {
        SearchTree<Student, String> redBlackBinarySearchTree = new RedBlackBinarySearchTree<>();
        Student firstStudent = new Student(1, "Suraj", "Pune");
        redBlackBinarySearchTree.put(firstStudent, "Suraj");
        assertEquals(redBlackBinarySearchTree.get(firstStudent), "Suraj");
        Student secondStudent = new Student(2, "Raj", "Satara");
        redBlackBinarySearchTree.put(secondStudent, "Raj");
        assertEquals(redBlackBinarySearchTree.get(secondStudent), "Raj");
        Student thirdStudent = new Student(3, "Mahesh", "Mumbai");
        redBlackBinarySearchTree.put(thirdStudent, "Mahesh");
        assertEquals(redBlackBinarySearchTree.get(thirdStudent), "Mahesh");
        Student fourthStudent = new Student(3, "Akshay", "Karad");
        redBlackBinarySearchTree.put(fourthStudent, "Akshay");
        assertEquals(redBlackBinarySearchTree.get(fourthStudent), "Akshay");
    }

    @Test
    public void minKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("a", redBlackBinarySearchTree.min());
    }

    @Test
    public void maxKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("x", redBlackBinarySearchTree.max());
    }

    @Test
    public void floorKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("x", redBlackBinarySearchTree.floor("x"));
        assertEquals("a", redBlackBinarySearchTree.floor("a"));
        assertEquals("x", redBlackBinarySearchTree.floor("z"));
        assertEquals("m", redBlackBinarySearchTree.floor("o"));
    }

    @Test
    public void ceilingKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("a", redBlackBinarySearchTree.ceiling("a"));
        assertEquals("x", redBlackBinarySearchTree.ceiling("x"));
        assertEquals("p", redBlackBinarySearchTree.ceiling("o"));
        assertEquals(null, redBlackBinarySearchTree.ceiling("z"));
    }

    @Test
    public void selectKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("a", redBlackBinarySearchTree.select(0));
        assertEquals("c", redBlackBinarySearchTree.select(1));
        assertEquals("e", redBlackBinarySearchTree.select(2));
    }

    @Test
    public void rankKey() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals(0, redBlackBinarySearchTree.rank("a"));
        assertEquals(8, redBlackBinarySearchTree.rank("s"));
    }

    @Test
    public void deleteMin() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("a", redBlackBinarySearchTree.min());
        redBlackBinarySearchTree.deleteMin();
        assertEquals("c", redBlackBinarySearchTree.min());
    }

    @Test
    public void deleteMax() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertEquals("x", redBlackBinarySearchTree.max());
        redBlackBinarySearchTree.deleteMax();
        assertEquals("s", redBlackBinarySearchTree.max());
    }

    @Test
    public void contains() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        assertTrue(redBlackBinarySearchTree.contains("a"));
        assertFalse(redBlackBinarySearchTree.contains("z"));
    }

    @Test
    public void delete() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        redBlackBinarySearchTree.delete("e");
        assertEquals(null, redBlackBinarySearchTree.get("e"));
    }

    @Test
    public void print() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        redBlackBinarySearchTree.print();
        System.out.println();
    }

    @Test
    public void keys() {
        SearchTree<String, String> redBlackBinarySearchTree = constructDummyStringTree();
        System.out.println();
        redBlackBinarySearchTree.keys().forEach(key -> System.out.print(" " + key));
        System.out.println();
        redBlackBinarySearchTree.keys("f", "t").forEach(key -> System.out.print(" " + key));
        System.out.println();
    }

}
