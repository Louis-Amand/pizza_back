package com.example.pizza_back.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // Inclure uniquement les propriétés non nulles dans la sérialisation JSON
public class Commandes {
    private String orderId;
    private String hour;
    private String name;
    private String firstName;
    private String phone;
    private String address;
    private String price;
    private String pizza_name;

    @JsonProperty("pizza_base")
    private Base pizza_base;

    @JsonProperty("pizza_ingredients")
    private Ingredient[] pizza_ingredients;
}
