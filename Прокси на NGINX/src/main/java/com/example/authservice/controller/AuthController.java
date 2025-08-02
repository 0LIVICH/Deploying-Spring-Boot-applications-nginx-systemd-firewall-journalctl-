package com.example.authservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    // Простая проверка авторизации
    @GetMapping("/authorize")
    public Map<String, Object> authorize(
            @RequestParam String user,
            @RequestParam String password) {
        
        Map<String, Object> response = new HashMap<>();
        
        // Простая проверка (в реальном приложении здесь была бы база данных)
        if ("admin".equals(user) && "password".equals(password)) {
            response.put("status", "success");
            response.put("message", "Authorization successful");
            response.put("user", user);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
        }
        
        return response;
    }

    // Эндпоинт для проверки работоспособности
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "auth-service");
        return response;
    }
} 