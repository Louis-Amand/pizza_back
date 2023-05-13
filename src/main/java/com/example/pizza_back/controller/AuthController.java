package com.example.pizza_back.controller;

import com.example.pizza_back.entity.Ingredient;
import com.example.pizza_back.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 */
@RestController
public class AuthController {

    /**
     * @param user
     * @return
     * @throws IOException
     */
    @PostMapping("/api/login")
    public Boolean authCheck(@RequestBody User user) throws IOException {
        Boolean auth = false;

        Gson gson = new Gson();
        Object object = gson.fromJson(new FileReader("./assets/json/auth/auth.json"), User.class);

        if (object != null && user != null) {
            User compare = (User) object;
            if (compare.getEmail().equals(user.getEmail()) && compare.getPassword().equals(user.getPassword())) {
                auth = true;
            }
        }
        return auth;
    }
}