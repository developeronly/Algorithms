package com.example.chapter1.unionfind;

public abstract class Union {

    private int[] ids;
    private int numberOfUnionFound;

    protected Union(int numberOfSites) {
        this.numberOfUnionFound = numberOfSites;
        this.ids = new int[numberOfSites];
        for (int index = 0; index < numberOfSites; index++)
            ids[index] = index;
    }

    protected abstract int find(int site);

    protected abstract void union(int firstSite, int secondSite);

    protected abstract void printUnions();

    protected boolean isConnected(int firstSite, int secondSite) throws ArrayIndexOutOfBoundsException {
        return find(firstSite) == find(secondSite);
    }

    protected void addSite(int firstSite, int secondSite) throws ArrayIndexOutOfBoundsException {
        if (isConnected(firstSite, secondSite)) return;
        union(firstSite, secondSite);
    }

    protected int count() {
        return numberOfUnionFound;
    }

    protected int[] getIds() {
        return ids;
    }

    protected void setIds(int[] ids) {
        this.ids = ids;
    }

    protected int getNumberOfUnionFound() {
        return numberOfUnionFound;
    }

    protected void setNumberOfUnionFound(int numberOfUnionFound) {
        this.numberOfUnionFound = numberOfUnionFound;
    }

}
