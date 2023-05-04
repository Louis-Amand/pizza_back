package com.example.pizza_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String getTestMessage() {
        return "Ceci est un message de test depuis le back-end Java Spring.";
    }
}
