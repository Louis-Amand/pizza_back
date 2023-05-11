package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Pizza;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The type Pizza controller.
 */
@RestController
public class PizzaController {

    /**
     * Gets all pizzas.
     *
     * @return the all pizzas
     * @throws Exception the exception
     */
    @GetMapping("/api/getAllPizzas")
    public ArrayList<Pizza> getAllPizzas() throws Exception {
        String fileName = "./assets/json/pizzas/pizza_list.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        return new Gson().fromJson(json, new TypeToken<ArrayList<Pizza>>() {
        }.getType());
    }
}