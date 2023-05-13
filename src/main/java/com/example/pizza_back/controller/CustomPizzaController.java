package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Base;
import com.example.pizza_back.entity.CustomPizza;
import com.example.pizza_back.entity.Ingredient;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;

@RestController
public class CustomPizzaController {

    /**
     * @return
     * @throws IOException
     */
    @GetMapping("/api/ingredients")
    public Object getIngredient() throws IOException {
        Gson gson = new Gson();
        Object object = gson.fromJson(new FileReader("./assets/json/ingredient/ingredients.json"), Object.class);

        return object;
    }

    /**
     * @param objet
     * @return
     * @throws IOException
     */
    @PostMapping("/api/ingredient")
    public ArrayList<Ingredient> getIngredient(@RequestBody Ingredient objet) throws IOException {

        String fileName = "./assets/json/ingredient/ingredients.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Ingredient> Ingredients = new Gson().fromJson(json, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        Ingredients.add(new Ingredient(objet.getName(), objet.getId(),objet.getPrice()));

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(Ingredients);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return Ingredients;
    }

    /**
     * @param id
     * @return
     * @throws IOException
     */
    @DeleteMapping("/api/deleteIngredient/{id}")
    public  Boolean deleteIngredientFromList(@PathVariable String id) throws IOException {
        final Boolean[] result = {false};
        String fileName = "./assets/json/ingredient/ingredients.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Ingredient> Ingredients = new Gson().fromJson(json, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        Ingredients.removeIf(new Predicate<Ingredient>() {
            @Override
            public boolean test(Ingredient ingredient) {
                if (ingredient.getId() == Integer.parseInt(id)) {
                    result[0] = true;
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

        return result[0];
    }

    /**
     * @param id
     * @param objet
     * @return
     * @throws IOException
     */
    @PutMapping("/api/ingredient/{id}")
    public ArrayList<Ingredient> updateIngredients(@PathVariable String id, @RequestBody Ingredient objet) throws IOException {

        String fileName = "./assets/json/ingredient/ingredients.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Ingredient> Ingredients = new Gson().fromJson(json, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        for (Ingredient ingredient : Ingredients) {
            if (ingredient.getId() == Integer.parseInt(id) && objet.getName() != null) {
                ingredient.setName(objet.getName());
                ingredient.setPrice(objet.getPrice());
            }
        }

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(Ingredients);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return Ingredients;
    }

    /**
     * @return
     * @throws IOException
     */
    @GetMapping("/api/bases")
    public ArrayList<Base> getBases() throws IOException {

        String fileName = "./assets/json/bases/bases.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        ArrayList<Base> bases = new Gson().fromJson(json, new TypeToken<ArrayList<Base>>() {
        }.getType());
        // convertir la chaîne JSON en ArrayList d'objets

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(bases);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return bases;
    }

    /**
     * @param objet
     * @return
     * @throws IOException
     */
    @PostMapping("/api/base")
    public ArrayList<Base> postBase(@RequestBody Base objet) throws IOException {

        String fileName = "./assets/json/bases/bases.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Base> bases = new Gson().fromJson(json, new TypeToken<ArrayList<Base>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        bases.add(new Base(objet.getName(), objet.getId()));

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(bases);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return bases;
    }

    /**
     * @param id
     * @return
     * @throws IOException
     */
    @DeleteMapping("/api/deleteBase/{id}")
    public Boolean deleteBaseFromList(@PathVariable String id) throws IOException {
        final Boolean[] result = {false};
        String fileName = "./assets/json/bases/bases.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Base> bases = new Gson().fromJson(json, new TypeToken<ArrayList<Base>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        bases.removeIf(new Predicate<Base>() {
            @Override
            public boolean test(Base base) {
                if (base.getId() == Integer.parseInt(id)) {
                    result[0] =true;
                    return true;
                }
                return false;
            }
        });

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(bases);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return result[0];
    }

    /**
     * @param id
     * @param objet
     * @return
     * @throws IOException
     */
    @PutMapping("/api/base/{id}")
    public ArrayList<Base> updateIngredients(@PathVariable String id, @RequestBody Base objet) throws IOException {

        String fileName = "./assets/json/bases/bases.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<Base> bases = new Gson().fromJson(json, new TypeToken<ArrayList<Base>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        for (Base Base : bases) {
            if (Base.getId() == Integer.parseInt(id) && objet.getName() != null) {
                Base.setName(objet.getName());
            }
        }

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(bases);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();

        return bases;
    }

    /**
     * @return
     * @throws IOException
     */
    @GetMapping("/api/customPizzas/lastId")
    public int getCustomPizzas() throws IOException {
        Gson gson = new Gson();
        Object object = gson.fromJson(new FileReader("./assets/json/customPizza/customPizza.json"), Object.class);
        // get last id from CustomPizza list objet
        ArrayList<CustomPizza> customPizzas = gson.fromJson(gson.toJson(object), new TypeToken<ArrayList<CustomPizza>>() {
        }.getType());

        if (customPizzas.size() == 0) {
            return 0;
        } else {
            return customPizzas.get(customPizzas.size() - 1).getId();
        }

    }

    /**
     * @param objet
     * @return
     * @throws IOException
     */
    @PostMapping("/api/customPizza")
    public CustomPizza postCustomPizza(@RequestBody CustomPizza objet) throws IOException {

        String fileName = "./assets/json/customPizza/customPizza.json";
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        // convertir la chaîne JSON en ArrayList d'objets
        ArrayList<CustomPizza> customPizzas = new Gson().fromJson(json, new TypeToken<ArrayList<CustomPizza>>() {
        }.getType());

        // ajouter un nouvel objet à l'ArrayList
        customPizzas.add(new CustomPizza(objet.getUuid(), objet.getId(), objet.getBase(), objet.getIngredients()));

        // convertir l'ArrayList en JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUpdated = gson.toJson(customPizzas);

        // écrire le JSON mis à jour dans le fichier
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonUpdated);
        writer.close();
        return objet;
    }
}
