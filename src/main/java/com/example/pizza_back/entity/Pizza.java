package com.example.pizza_back.entity;

import java.util.List;

public class Pizza {
    private long id;
    private String name;
    private String image;

    private String price;
    private List<String> ingredients;

    public Pizza(long id, String name, String image, String price, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}