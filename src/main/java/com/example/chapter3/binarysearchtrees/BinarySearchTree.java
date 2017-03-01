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
