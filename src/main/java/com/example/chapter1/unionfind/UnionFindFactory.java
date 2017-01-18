package com.example.chapter1.unionfind;

public class UnionFindFactory {

    public static Union create(UnionFindType unionFindType, int numberOfSites) {
        Union union;
        switch (unionFindType) {
            case QuickFind:
                union = new QuickFind(numberOfSites);
                break;
            case QuickUnion:
                union = new QuickUnion(numberOfSites);
                break;
            case WeightedQuick:
                union = new WeightedQuick(numberOfSites);
                break;
            default:
                throw new IllegalStateException("Invalid Union Type.");
        }
        return union;
    }
    
}
