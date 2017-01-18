package com.example.chapter1.unionfind;

//Refer test data from resources/txt/tinyUF.txt
public class UnionFindHelper {

    public static Union setup(UnionFindType unionFindType) {
        int numberOfSites = 10;
        Union union = UnionFindFactory.create(unionFindType, numberOfSites);
        union.addSite(4, 3);
        union.addSite(3, 8);
        union.addSite(6, 5);
        union.addSite(9, 4);
        union.addSite(2, 1);
        union.addSite(8, 9);
        union.addSite(5, 0);
        union.addSite(7, 2);
        union.addSite(6, 1);
        union.addSite(1, 0);
        union.addSite(6, 7);
        union.printUnions();
        return union;
    }

}
