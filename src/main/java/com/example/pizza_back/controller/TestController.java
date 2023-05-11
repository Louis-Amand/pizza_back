package com.example.pizza_back.controller;

import com.google.gson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String getTestMessage() throws IOException {
        return "Ceci est un message de sdqsd depuis le back-end Java Spring.";
    }


    @PostMapping("/api/jsonTest")
    public String postJsonTest(@RequestBody String response) throws IOException {
        Boolean test = true;
        try (Writer writer = new FileWriter("./saveJson/Output.json")) {
            if (response == null) {
                test = false;
            } else {
                Gson gson = new GsonBuilder().create();
                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                JsonElement element = gson.toJsonTree(jsonObject);
                gson.toJson(element, writer);
            }
        }
        return test ? "Json saved" : "Json not saved";
    }
}
