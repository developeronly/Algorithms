package com.example.chapter3.hashtables;

public class HashSymbolTableFactory {

    public static HashSymbolTable get(HashSymbolTableType hashSymbolTableType) {
        switch (hashSymbolTableType) {
            case SEPARATE_CHAINING:
                return new SeparateChainingHashTable();
            default:
                throw new IllegalArgumentException("Invalid hash symbol table type.");
        }
    }

}
