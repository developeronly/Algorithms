package com.example.chapter1.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//Refer test data from resources/txt/tinyUF.txt
public class QuickFindTest {

    private Union initialize(int numberOfSites) {
        Union quickFind = new QuickFind(numberOfSites);
        quickFind.addSite(4, 3);
        quickFind.addSite(3, 8);
        quickFind.addSite(6, 5);
        quickFind.addSite(9, 4);
        quickFind.addSite(2, 1);
        quickFind.addSite(8, 9);
        quickFind.addSite(5, 0);
        quickFind.addSite(7, 2);
        quickFind.addSite(6, 1);
        quickFind.addSite(1, 0);
        quickFind.addSite(6, 7);
        quickFind.printUnions();
        return quickFind;
    }

    @Test
    public void checkSitesAreConnected() {
        Union quickFind = initialize(10);
        assertTrue(quickFind.isConnected(4, 3));
        assertFalse(quickFind.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        Union quickFind = initialize(10);
        assertEquals(2, quickFind.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        Union quickFind = initialize(10);
        quickFind.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        Union quickFind = initialize(10);
        quickFind.isConnected(32, 32);
    }

}
