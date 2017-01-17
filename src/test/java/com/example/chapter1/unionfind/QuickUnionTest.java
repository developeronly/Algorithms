package com.example.chapter1.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickUnionTest {

    private Union initialize(int numberOfSites) {
        Union quickUnion = new QuickUnion(numberOfSites);
        quickUnion.addSite(4, 3);
        quickUnion.addSite(3, 8);
        quickUnion.addSite(6, 5);
        quickUnion.addSite(9, 4);
        quickUnion.addSite(2, 1);
        quickUnion.addSite(8, 9);
        quickUnion.addSite(5, 0);
        quickUnion.addSite(7, 2);
        quickUnion.addSite(6, 1);
        quickUnion.addSite(1, 0);
        quickUnion.addSite(6, 7);
        quickUnion.printUnions();
        return quickUnion;
    }

    @Test
    public void checkSitesAreConnected() {
        Union quickUnion = initialize(10);
        assertTrue(quickUnion.isConnected(4, 3));
        assertFalse(quickUnion.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        Union quickUnion = initialize(10);
        assertEquals(2, quickUnion.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        Union quickUnion = initialize(10);
        quickUnion.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        Union quickUnion = initialize(10);
        quickUnion.isConnected(32, 32);
    }

}
