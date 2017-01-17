package com.example.chapter1.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {

    private int[] ids;
    private int numberOfUnionFound;

    public UnionFind(int numberOfSites) {
        this.numberOfUnionFound = numberOfSites;
        this.ids = new int[numberOfSites];
        for (int index = 0; index < numberOfSites; index++)
            ids[index] = index;
    }

    private int find(int site) {
        return ids[site];
    }

    private void union(int firstSite, int secondSite) {
        int firstSiteId = find(firstSite);
        int secondSiteId = find(secondSite);

        if (firstSiteId == secondSiteId) return;

        for (int index = 0; index < ids.length; index++) {
            if (ids[index] == firstSiteId)
                ids[index] = secondSiteId;
        }
        numberOfUnionFound--;
    }

    public boolean isConnected(int firstSite, int secondSite) throws ArrayIndexOutOfBoundsException {
        return find(firstSite) == find(secondSite);
    }

    public void addSite(int firstSite, int secondSite) throws ArrayIndexOutOfBoundsException {
        if (isConnected(firstSite, secondSite)) return;
        union(firstSite, secondSite);
    }

    public int count() {
        return numberOfUnionFound;
    }

    public void printUnions() {
        Map<Integer, Component> components = new HashMap<Integer, Component>();
        for (int index = 0; index < ids.length; index++) {
            Component component = components.get(ids[index]);
            if (null == component) {
                component = new Component();
            }
            component.addSite(index);
            components.put(ids[index], component);
        }

        components.entrySet().stream().forEach(component ->
                component.getValue().sites.stream().forEach(site -> System.out.println(site)));

        System.out.println("Total Union Found : " + count());
    }

    private class Component {

        List<Integer> sites = new ArrayList<>();

        public void addSite(int id) {
            sites.add(id);
        }

        public List sites() {
            return sites;
        }
    }

}
