package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Pizza;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;

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

    @PostMapping("/api/pizza")
    public ArrayList<Pizza> postPizza(@RequestBody Pizza objet) throws IOException {

        String fileName = "./assets/json/pizzas/pizza_list.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Pizza> pizzas = new Gson().fromJson(json, new TypeToken<ArrayList<Pizza>>() {
        }.getType());
        // ajouter un nouvel objet à l'ArrayList
        pizzas.add(new Pizza(objet.getId(), objet.getName(), objet.getImage(), objet.getPrice(), objet.getIngredients()));

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(pizzas);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return pizzas;
    }

    @DeleteMapping("/api/deletePizza/{id}")
    public  Boolean deletePizzaFromList(@PathVariable String id) throws IOException {
        final Boolean[] result = {false};
        String fileName = "./assets/json/pizzas/pizza_list.json";

        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Pizza> pizzas = new Gson().fromJson(json, new TypeToken<ArrayList<Pizza>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        pizzas.removeIf(new Predicate<Pizza>() {
            @Override
            public boolean test(Pizza pizza) {
                if (pizza.getId() == Integer.parseInt(id)) {
                    result[0] = true;
                    return true;
                }
                return false;
            }
        });

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(pizzas);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return result[0];
    }

    @PutMapping("/api/pizza/{id}")
    public ArrayList<Pizza> updatePizza(@PathVariable String id, @RequestBody Pizza objet) throws IOException {
        String fileName = "./assets/json/pizzas/pizza_list.json";

        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Pizza> pizzas = new Gson().fromJson(json, new TypeToken<ArrayList<Pizza>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        for (Pizza pizza : pizzas) {
            if (pizza.getId() == Integer.parseInt(id) && objet.getName() != null) {
                pizza.setName(objet.getName());
                pizza.setIngredients(objet.getIngredients());
                pizza.setPrice(objet.getPrice());
            }
        }

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(pizzas);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return pizzas;
    }

}