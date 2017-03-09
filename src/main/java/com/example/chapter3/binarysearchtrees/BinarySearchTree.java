package com.example.chapter3.binarysearchtrees;

import com.example.chapter1.bagsqueuesstacks.Queue;
import com.example.chapter3.SearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SearchTree<Key, Value> {

    private Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        else return root.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) return new Node(key, value, 1);
        int compare = key.compareTo(root.key);
        if (compare < 0) root.left = put(root.left, key, value);
        else if (compare > 0) root.right = put(root.right, key, value);
        else root.value = value;
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare < 0) return get(root.left, key);
        else if (compare > 0) return get(root.right, key);
        else return root.value;
    }

    @Override
    public Key min() {
        if (root == null) throw new IllegalStateException("Empty tree.");
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    @Override
    public Key max() {
        if (root == null) throw new IllegalStateException("Empty tree.");
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) return root;
        return max(root.right);
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Node root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare == 0) return root;
        if (compare < 0) return floor(root.left, key);
        Node node = floor(root.right, key);
        if (node != null) return node;
        else return root;
    }

    @Override
    public Key ceiling(Key key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }


    private Node ceiling(Node root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare == 0) return root;
        if (compare < 0) {
            Node node = ceiling(root.left, key);
            if (node != null) return node;
            else return root;
        }
        return ceiling(root.right, key);
    }

    @Override
    public Key select(int index) {
        return select(root, index).key;
    }

    private Node select(Node root, int index) {
        if (root == null) return null;
        int size = size(root.left);
        if (size > index) return select(root.left, index);
        else if (size < index) return select(root.right, index - size - 1);
        else return root;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node root) {
        if (root == null) return 0;
        int compare = key.compareTo(root.key);
        if (compare < 0) return rank(key, root.left);
        else if (compare > 0) return 1 + size(root.left) + rank(key, root.right);
        else return size(root.left);
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node root) {
        if (root.right == null) return root.left;
        root.right = deleteMax(root.right);
        root.size = size(root.right) + size(root.left) + 1;
        return root;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare < 0) root.left = delete(root.left, key);
        else if (compare > 0) root.right = delete(root.right, key);
        else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            Node node = root;
            root = min(node.right);
            root.right = deleteMin(node.right);
            root.left = node.left;
        }
        root.size = size(root.right) + size(root.left) + 1;
        return root;
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null) return;
        print(node.left);
        System.out.print(" " + node.key);
        print(node.right);
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key min, Key max) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, min, max);
        return queue;
    }

    private void keys(Node root, Queue<Key> queue, Key min, Key max) {
        if (root == null) return;
        int compareMin = min.compareTo(root.key);
        int compareMax = max.compareTo(root.key);
        if (compareMin < 0) keys(root.left, queue, min, max);
        if (compareMin <= 0) queue.enqueue(root.key);
        if (compareMax > 0) keys(root.right, queue, min, max);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

}
