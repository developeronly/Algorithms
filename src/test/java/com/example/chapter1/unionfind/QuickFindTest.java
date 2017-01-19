package com.example.chapter1.unionfind;

import org.junit.Test;

import static com.example.chapter1.unionfind.UnionFindType.QuickFind;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickFindTest {

    private Union initialize() {
        return UnionFindHelper.setup(QuickFind);
    }

    @Test
    public void checkSitesAreConnected() {
        Union quickFind = initialize();
        assertTrue(quickFind.isConnected(4, 3));
        assertFalse(quickFind.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        Union quickFind = initialize();
        assertEquals(2, quickFind.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        Union quickFind = initialize();
        quickFind.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        Union quickFind = initialize();
        quickFind.isConnected(32, 32);
    }

}
