package com.example.chapter3.balancedsearchtrees;

import com.example.chapter1.bagsqueuesstacks.Queue;
import com.example.chapter3.SearchTree;

public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> implements SearchTree<Key, Value> {

    private static final boolean BLACK = false;
    private static final boolean RED = true;

    private Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        return root.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) return new Node(key, value, RED, 1);
        int compare = key.compareTo(root.key);
        if (compare < 0) root.left = put(root.left, key, value);
        else if (compare > 0) root.right = put(root.right, key, value);
        else root.value = value;

        if (isRed(root.right) && !isRed(root.left)) root = rotateLeft(root);
        if (isRed(root.left) && isRed(root.left.left)) root = rotateRight(root);
        if (isRed(root.left) && isRed(root.right)) flipColors(root);
        root.size = size(root.left) + size(root.right) + 1;

        return root;
    }

    private void flipColors(Node root) {
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
    }

    private Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        temp.color = temp.right.color;
        temp.right.color = RED;
        temp.size = root.size;
        root.size = size(root.right) + size(root.left) + 1;
        return temp;
    }

    private Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        temp.color = temp.left.color;
        temp.left.color = RED;
        temp.size = root.size;
        root.size = size(root.left) + size(root.right) + 1;
        return temp;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Invalid key. Key can't be null.");
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        while (root != null) {
            int compare = key.compareTo(root.key);
            if (compare < 0) root = root.left;
            else if (compare > 0) root = root.right;
            else return root.value;
        }

        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        else return min(root.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) return root;
        else return max(root.right);
    }

    @Override
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("Invalid key. Key can't be null.");
        Node node = floor(root, key);
        if (node == null) return null;
        else return node.key;
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
        if (key == null) throw new IllegalArgumentException("Invalid key. Key can't be null.");
        Node node = ceiling(root, key);
        if (node == null) return null;
        else return node.key;
    }

    private Node ceiling(Node root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare == 0) return root;
        if (compare > 0) return ceiling(root.right, key);
        Node node = ceiling(root.left, key);
        if (node != null) return node;
        else return root;
    }

    @Override
    public Key select(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Invalid index: " + index);
        Node node = select(root, index);
        return node.key;
    }

    private Node select(Node node, int index) {
        int size = size(node.left);
        if (size > index) return select(node.left, index);
        else if (size < index) return select(node.right, index - size - 1);
        else return node;
    }

    @Override
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("Invalid key. Key can't be null.");
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int compare = key.compareTo(node.key);
        if (compare < 0) return rank(key, node.left);
        else if (compare > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }

    private Node balance(Node node) {
        if (isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return null;
        if (!isRed(node.left) && !isRed(node.left.left)) node = moveRedLeft(node);
        node.left = deleteMin(node.left);
        return balance(node);
    }

    @Override
    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node node) {
        if (isRed(node.left)) node = rotateRight(node);
        if (node.right == null) return null;
        if (!isRed(node.right) && !isRed(node.right.left)) node = moveRedRight(node);

        node.right = deleteMax(node.right);
        return balance(node);
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Invalid key. Key can't be null.");
        if (!contains(key)) return;
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left))
                node = moveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left))
                node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null))
                return null;
            if (!isRed(node.right) && !isRed(node.right.left))
                node = moveRedRight(node);
            if (key.compareTo(node.key) == 0) {
                Node x = min(node.right);
                node.key = x.key;
                node.value = x.value;
                node.right = deleteMin(node.right);
            } else node.right = delete(node.right, key);
        }
        return balance(node);
    }

    @Override
    public void print() {
        print(root);
    }

    @Override
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key low, Key high) {
        if (node == null) return;
        int compareLow = low.compareTo(node.key);
        int compareHigh = high.compareTo(node.key);
        if (compareLow < 0) keys(node.left, queue, low, high);
        if (compareLow <= 0 && compareHigh >= 0) queue.enqueue(node.key);
        if (compareHigh > 0) keys(node.right, queue, low, high);
    }

    private void print(Node node) {
        if (node == null) return;
        print(node.left);
        System.out.print(" " + node.key);
        print(node.right);
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }
}
