package com.murli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping("/")
    public String demo() {
        return "Welcome to our new project";
    }
}
