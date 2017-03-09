package com.example.chapter3;

import com.example.chapter3.balancedsearchtrees.RedBlackBinarySearchTree;
import com.example.chapter3.binarysearchtrees.BinarySearchTree;

public class TreeFactory {

    public static SearchTree searchTree(SearchTreeType searchTreeType) {
        switch (searchTreeType) {
            case BALANCED_SEARCH_TREE:
                return new RedBlackBinarySearchTree();
            case BINARY_SEARCH_TREE:
                return new BinarySearchTree();
            default:
                throw new IllegalArgumentException("Invalid tree type.");
        }
    }

}
