package com.example.chapter1.unionfind;

import org.junit.Test;

import static com.example.chapter1.unionfind.UnionFindType.QuickUnion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickUnionTest {

    private Union initialize() {
        return UnionFindHelper.setup(QuickUnion);
    }

    @Test
    public void checkSitesAreConnected() {
        Union quickUnion = initialize();
        assertTrue(quickUnion.isConnected(4, 3));
        assertFalse(quickUnion.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        Union quickUnion = initialize();
        assertEquals(2, quickUnion.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        Union quickUnion = initialize();
        quickUnion.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        Union quickUnion = initialize();
        quickUnion.isConnected(32, 32);
    }

}
