package com.example.chapter1.unionfind;

import com.example.models.Component;

import java.util.HashMap;
import java.util.Map;

//Implemented using weighted tree.
public class WeightedQuick extends Union {

    private int[] sizeOfRoots;

    public WeightedQuick(int numberOfSites) {
        super(numberOfSites);
        sizeOfRoots = new int[numberOfSites];
        for (int index = 0; index < numberOfSites; index++)
            sizeOfRoots[index] = index;
    }

    @Override
    public int find(int site) {
        while (site != getIds()[site]) site = getIds()[site];
        return site;
    }

    @Override
    public void union(int firstSite, int secondSite) {
        int firstSiteRoot = find(firstSite);
        int secondSiteRoot = find(secondSite);

        if (firstSiteRoot == secondSiteRoot) return;

        if (sizeOfRoots[firstSiteRoot] < sizeOfRoots[secondSiteRoot]) {
            getIds()[firstSiteRoot] = secondSiteRoot;
            sizeOfRoots[secondSiteRoot] += sizeOfRoots[firstSiteRoot];
        } else {
            getIds()[secondSiteRoot] = firstSiteRoot;
            sizeOfRoots[firstSiteRoot] += sizeOfRoots[secondSiteRoot];
        }

        setNumberOfUnionFound(getNumberOfUnionFound() - 1);
    }

    @Override
    public void printUnions() {
        Map<Integer, Component> components = new HashMap<>();
        for (int index = 0; index < getIds().length; index++) {
            int root = find(index);
            Component component = components.get(root);
            if (null == component) {
                component = new Component();
            }
            component.addSite(index);
            components.put(root, component);
        }

        components.entrySet().stream().forEach(component -> {
            System.out.println();
            component.getValue().getSites().stream().forEach(site -> System.out.print(" " + site));
        });

        System.out.println();
        System.out.println("Total Union Found : " + count());
    }

}
