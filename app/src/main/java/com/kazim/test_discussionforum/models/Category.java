package com.kazim.test_discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public String getName() {
        return name;
    }

}
