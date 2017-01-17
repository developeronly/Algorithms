package com.example.chapter1.unionfind;

import com.example.models.Component;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion extends Union {

    public QuickUnion(int numberOfSites) {
        super(numberOfSites);
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

        getIds()[firstSiteRoot] = secondSiteRoot;
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
