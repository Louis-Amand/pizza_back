package com.example.pizza_back.entity;

public class Ingredient {
    private String name;
    private int id;
    private Float price;

    /**
     * @param name
     * @param id
     * @param price
     */
    public Ingredient(String name, int id,Float price) {
        this.name = name;
        this.id = id;
        this.price=price;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
