package com.boarhat.springsecuritypractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        return String.format("Hello %s!", principal.getName());
    }
}
