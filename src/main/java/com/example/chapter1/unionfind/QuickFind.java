package com.example.chapter1.unionfind;

import com.example.models.Component;

import java.util.HashMap;
import java.util.Map;

public class QuickFind extends Union {

    public QuickFind(int numberOfSites) {
        super(numberOfSites);
    }

    @Override
    public int find(int site) {
        return getIds()[site];
    }

    @Override
    public void union(int firstSite, int secondSite) {
        int firstSiteId = find(firstSite);
        int secondSiteId = find(secondSite);

        if (firstSiteId == secondSiteId) return;

        for (int index = 0; index < getIds().length; index++) {
            if (getIds()[index] == firstSiteId)
                getIds()[index] = secondSiteId;
        }
        setNumberOfUnionFound(getNumberOfUnionFound() - 1);
    }

    @Override
    public void printUnions() {
        Map<Integer, Component> components = new HashMap<>();
        for (int index = 0; index < getIds().length; index++) {
            Component component = components.get(getIds()[index]);
            if (null == component) {
                component = new Component();
            }
            component.addSite(index);
            components.put(getIds()[index], component);
        }

        components.entrySet().stream().forEach(component -> {
            System.out.println();
            component.getValue().getSites().stream().forEach(site -> System.out.print(" " + site));
        });

        System.out.println();
        System.out.println("Total Union Found : " + count());
    }

}
