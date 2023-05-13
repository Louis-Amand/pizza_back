package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Commandes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Command controller.
 */
@RestController
public class CommandController {

    /**
     * Post commandes.
     *
     * @param objet the objet
     * @throws IOException the io exception
     */
    @PostMapping("/api/commandes")
    public void postCommandes(@RequestBody Commandes objet) throws IOException {
        writeToJsonFile(objet); // Logique de traitement de la commande
    }

    /**
     * @param objet
     * @throws IOException
     */
    private void writeToJsonFile(Commandes objet) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Commandes> commandList = new ArrayList<>();

        File file = new File("./assets/json/order/order.json");
        if (file.length() != 0) {
            // Lire les données existantes
            try (FileReader fileReader = new FileReader(file)) {
                Type listType = new TypeToken<ArrayList<Commandes>>(){}.getType();
                commandList = gson.fromJson(fileReader, listType);
            } catch (JsonSyntaxException e) {
                // Ignore l'exception, crée une nouvelle liste si le fichier ne contient pas un tableau JSON
            }
        }

        // Ajouter la nouvelle commande à la liste
        commandList.add(objet);

        // Écrire la liste dans le fichier
        try (FileWriter fileWriter = new FileWriter("./assets/json/order/order.json")) {
            gson.toJson(commandList, fileWriter);
        }
    }
}
