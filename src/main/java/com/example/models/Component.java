package com.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Component {

    private List<Integer> sites = new ArrayList<>();

    public void addSite(int id) {
        sites.add(id);
    }

    public List getSites() {
        return Collections.unmodifiableList(sites);
    }

}
