package com.example.chapter1.unionfind;

import org.junit.Test;

import static com.example.chapter1.unionfind.UnionFindType.WeightedQuick;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickTest {

    private Union initialize() {
        return UnionFindHelper.setup(WeightedQuick);
    }

    @Test
    public void checkSitesAreConnected() {
        Union weightedQuick = initialize();
        assertTrue(weightedQuick.isConnected(4, 3));
        assertFalse(weightedQuick.isConnected(4, 0));
    }

    @Test
    public void numberOfTotalComponentsCreated() {
        Union weightedQuick = initialize();
        assertEquals(2, weightedQuick.count());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addSitesMoreThanInitializingComponent() {
        Union weightedQuick = initialize();
        weightedQuick.addSite(32, 32);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIsConnectedForFalseSites() {
        Union weightedQuick = initialize();
        weightedQuick.isConnected(32, 32);
    }

}
