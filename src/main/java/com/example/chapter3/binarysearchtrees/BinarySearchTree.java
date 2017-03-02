package com.example.chapter3.binarysearchtrees;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        else return root.size;
    }

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

    public Key min() {
        if (root == null) throw new IllegalStateException("Empty tree.");
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    public Key max() {
        if (root == null) throw new IllegalStateException("Empty tree.");
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) return root;
        return max(root.right);
    }

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
