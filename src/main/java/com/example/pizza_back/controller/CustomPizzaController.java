package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Ingredient;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Predicate;

@RestController
public class CustomPizzaController {

    @GetMapping("/api/ingredients")
    public Object getIngredient() throws IOException {
        Gson gson = new Gson();
        Object object = gson.fromJson(new FileReader("./jsonData/ingredients.json"), Object.class);

        return object;
    }

    @PostMapping("/api/ingredient")
    public ArrayList<Ingredient> getIngredient(@RequestBody Ingredient objet) throws IOException {

        String fileName = "./assets/ingredients.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Ingredient> Ingredients = new Gson().fromJson(json, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        Ingredients.add(new Ingredient(objet.getName(), objet.getId()));

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(Ingredients);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return Ingredients;
    }

    @DeleteMapping("/api/deleteIngredient/{id}")
    public ArrayList<Ingredient> deleteIngredientFromList(@PathVariable String id) throws IOException {

        String fileName = "./assets/ingredients.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Ingredient> Ingredients = new Gson().fromJson(json, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        Ingredients.removeIf(new Predicate<Ingredient>() {
            @Override
            public boolean test(Ingredient ingredient) {
                if (ingredient.getId() == Integer.parseInt(id)) {
                    return true;
                }
                return false;
            }
        });

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(Ingredients);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return Ingredients;
    }
}
