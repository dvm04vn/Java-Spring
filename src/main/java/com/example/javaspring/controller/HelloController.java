package com.example.javaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // báo cho Spring biết đây là class API
public class HelloController {
    @GetMapping("/api/hello") // API method GET
    public String hello() {
        return "Hello Java Spring Boot";
    }
}
