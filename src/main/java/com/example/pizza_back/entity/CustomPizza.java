package com.example.pizza_back.entity;

import java.util.ArrayList;

public class CustomPizza {

    private String uuid;
    private int id;
    private Base base;
    private ArrayList<Ingredient> ingredients;

    public CustomPizza(String uuid, int id, Base base, ArrayList<Ingredient> ingredients) {
        this.uuid = uuid;
        this.id = id;
        this.base = base;
        this.ingredients = ingredients;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
