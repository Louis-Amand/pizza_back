package com.example.pizza_back.entity;

public class Base {

    private String name;
    private int id;

    /**
     * @param name
     * @param id
     */
    public Base(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
