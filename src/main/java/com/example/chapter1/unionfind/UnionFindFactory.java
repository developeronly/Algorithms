package com.example.chapter1.unionfind;

public class UnionFindFactory {

    public static Union create(UnionFindType unionFindType, int numberOfSites) {
        Union union;
        switch (unionFindType) {
            case QUICK_FIND:
                union = new QuickFind(numberOfSites);
                break;
            case QUICK_UNION:
                union = new QuickUnion(numberOfSites);
                break;
            case WEIGHTED_QUICK:
                union = new WeightedQuick(numberOfSites);
                break;
            default:
                throw new IllegalStateException("Invalid Union Type.");
        }
        return union;
    }
    
}
