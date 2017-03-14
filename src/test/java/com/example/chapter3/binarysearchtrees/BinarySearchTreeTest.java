package com.example.chapter3.binarysearchtrees;

import com.example.chapter3.SearchTree;
import com.example.chapter3.TreeFactory;
import com.example.models.Student;
import org.junit.Test;

import static com.example.chapter3.SearchTreeType.BINARY_SEARCH_TREE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BinarySearchTreeTest {

    @Test
    public void init() {
        SearchTree binarySearchTree = TreeFactory.searchTree(BINARY_SEARCH_TREE);
        assertEquals(0, binarySearchTree.size());
        assertTrue(binarySearchTree.isEmpty());
    }

    public SearchTree constructDummyTree() {
        SearchTree<Integer, String> binarySearchTree = TreeFactory.searchTree(BINARY_SEARCH_TREE);
        binarySearchTree.put(3, "Suraj");
        binarySearchTree.put(4, "Raj");
        binarySearchTree.put(2, "Mahesh");
        binarySearchTree.put(1, "Akshay");
        return binarySearchTree;
    }

    public SearchTree constructDummyStringTree() {
        SearchTree<String, String> binarySearchTree = TreeFactory.searchTree(BINARY_SEARCH_TREE);
        binarySearchTree.put("s", "S");
        binarySearchTree.put("e", "E");
        binarySearchTree.put("a", "A");
        binarySearchTree.put("r", "R");
        binarySearchTree.put("c", "C");
        binarySearchTree.put("h", "H");
        binarySearchTree.put("e", "E");
        binarySearchTree.put("x", "X");
        binarySearchTree.put("a", "A");
        binarySearchTree.put("m", "M");
        binarySearchTree.put("p", "P");
        binarySearchTree.put("l", "L");
        binarySearchTree.put("e", "E");
        return binarySearchTree;
    }

    @Test
    public void putString() {
        SearchTree<Integer, String> binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(0, "Suraj");
        assertEquals(1, binarySearchTree.size());
        binarySearchTree.put(1, "Raj");
        assertEquals(2, binarySearchTree.size());
        binarySearchTree.put(2, "Mahesh");
        assertEquals(3, binarySearchTree.size());
    }

    @Test
    public void getString() {
        SearchTree<Integer, String> binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(0, "Suraj");
        binarySearchTree.put(1, "Raj");
        String expected = binarySearchTree.get(0);
        assertEquals(expected, "Suraj");
        expected = binarySearchTree.get(1);
        assertEquals(expected, "Raj");
        expected = binarySearchTree.get(3);
        assertEquals(expected, null);
    }

    @Test
    public void putAndGetForGeneric() {
        SearchTree<Student, String> binarySearchTree = new BinarySearchTree();
        Student firstStudent = new Student(1, "Suraj", "Pune");
        binarySearchTree.put(firstStudent, "Suraj");
        assertEquals(binarySearchTree.get(firstStudent), "Suraj");
        Student secondStudent = new Student(2, "Raj", "Satara");
        binarySearchTree.put(secondStudent, "Raj");
        assertEquals(binarySearchTree.get(secondStudent), "Raj");
        Student thirdStudent = new Student(3, "Mahesh", "Mumbai");
        binarySearchTree.put(thirdStudent, "Mahesh");
        assertEquals(binarySearchTree.get(thirdStudent), "Mahesh");
        Student fourthStudent = new Student(3, "Akshay", "Karad");
        binarySearchTree.put(fourthStudent, "Akshay");
        assertEquals(binarySearchTree.get(fourthStudent), "Akshay");
    }

    @Test
    public void minKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(1, binarySearchTree.min().longValue());
    }

    @Test
    public void maxKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(4, binarySearchTree.max().longValue());
    }

    @Test
    public void floorKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(4, binarySearchTree.floor(5).longValue());
        assertEquals(4, binarySearchTree.floor(4).longValue());
        assertEquals(null, binarySearchTree.floor(0));
    }

    @Test
    public void ceilingKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(3, binarySearchTree.ceiling(3).longValue());
        assertEquals(4, binarySearchTree.ceiling(5).longValue());
        assertEquals(null, binarySearchTree.ceiling(0));
    }

    @Test
    public void selectKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(4, binarySearchTree.select(3).longValue());
    }

    @Test
    public void rankKey() {
        SearchTree<Integer, String> binarySearchTree = constructDummyTree();
        assertEquals(2, binarySearchTree.rank(3));
    }

    @Test
    public void deleteMin() {
        SearchTree<Integer, String> binarySearchTree = constructDummyStringTree();
        assertEquals("a", binarySearchTree.min());
        binarySearchTree.deleteMin();
        assertEquals("c", binarySearchTree.min());
    }

    @Test
    public void deleteMax() {
        SearchTree<String, String> binarySearchTree = constructDummyStringTree();
        assertEquals("x", binarySearchTree.max());
        binarySearchTree.deleteMax();
        assertEquals("s", binarySearchTree.max());
    }

    @Test
    public void delete() {
        SearchTree<String, String> binarySearchTree = constructDummyStringTree();
        binarySearchTree.delete("e");
        assertEquals(null, binarySearchTree.get("e"));
    }

    @Test
    public void print() {
        SearchTree<String, String> binarySearchTree = constructDummyStringTree();
        binarySearchTree.print();
        System.out.println();
    }

    @Test
    public void keys() {
        SearchTree<String, String> binarySearchTree = constructDummyStringTree();
        System.out.println();
        binarySearchTree.keys().forEach(key -> System.out.print(" " + key));
        System.out.println();
        binarySearchTree.keys("f", "t").forEach(key -> System.out.print(" " + key));
        System.out.println();
    }

    @Test
    public void contains() {
        SearchTree<String, String> binarySearchTree = constructDummyStringTree();
        assertTrue(binarySearchTree.contains("a"));
        assertFalse(binarySearchTree.contains("z"));
    }

}
