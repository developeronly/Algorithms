package com.example.chapter3.binarysearchtrees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BinarySearchTreeTest {

    @Test
    public void init() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertEquals(0, binarySearchTree.size());
    }

    @Test
    public void putString() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(0, "Suraj");
        assertEquals(1, binarySearchTree.size());
        binarySearchTree.put(1, "Raj");
        assertEquals(2, binarySearchTree.size());
        binarySearchTree.put(2, "Mahesh");
        assertEquals(3, binarySearchTree.size());
    }

    @Test
    public void getString() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(0, "Suraj");
        binarySearchTree.put(1, "Raj");
        String expected = binarySearchTree.get(0);
        assertEquals(expected, "Suraj");
        expected = binarySearchTree.get(1);
        assertEquals(expected, "Raj");
        expected = binarySearchTree.get(3);
        assertEquals(expected, null);
    }

}
