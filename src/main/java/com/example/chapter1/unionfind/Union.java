package com.example.chapter1.unionfind;

public abstract class Union {

    private int[] ids;
    private int numberOfUnionFound;

    public Union(int numberOfSites) {
        this.numberOfUnionFound = numberOfSites;
        this.ids = new int[numberOfSites];
        for (int index = 0; index < numberOfSites; index++)
            ids[index] = index;
    }

    public abstract int find(int site);

    public abstract void union(int firstSite, int secondSite);

    public abstract void printUnions();

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

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public int getNumberOfUnionFound() {
        return numberOfUnionFound;
    }

    public void setNumberOfUnionFound(int numberOfUnionFound) {
        this.numberOfUnionFound = numberOfUnionFound;
    }

}
