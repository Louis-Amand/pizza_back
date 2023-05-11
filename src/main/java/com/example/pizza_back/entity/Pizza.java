package com.example.pizza_back.entity;

import java.util.List;

public class Pizza {
    private long id;
    private String name;
    private String image;
    private List<String> ingredients;

    public Pizza(long id, String name, String image, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}