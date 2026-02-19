package com.boarhat.springsecuritypractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World from GET";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Hello World from POST";
    }
}
