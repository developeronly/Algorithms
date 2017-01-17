package com.example.chapter1.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//Refer test data from resources/txt/tinyUF.txt
public class UnionFindTest {

    private UnionFind initialize(int numberOfSites) {
        UnionFind unionFind = new UnionFind(numberOfSites);
        unionFind.addSite(4, 3);
        unionFind.addSite(3, 8);
        unionFind.addSite(6, 5);
        unionFind.addSite(9, 4);
        unionFind.addSite(2, 1);
        unionFind.addSite(8, 9);
        unionFind.addSite(5, 0);
        unionFind.addSite(7, 2);
        unionFind.addSite(6, 1);
        unionFind.addSite(1, 0);
        unionFind.addSite(6, 7);
        unionFind.printUnions();
        return unionFind;
    }

    @Test
    public void checkSitesAreConnected() {
        UnionFind unionFind = initialize(10);
        assertTrue(unionFind.isConnected(4, 3));
        assertFalse(unionFind.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        UnionFind unionFind = initialize(10);
        assertEquals(2, unionFind.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        UnionFind unionFind = initialize(10);
        unionFind.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        UnionFind unionFind = initialize(10);
        unionFind.isConnected(32, 32);
    }

}
