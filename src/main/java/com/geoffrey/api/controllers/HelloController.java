package com.geoffrey.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String index() {
        return "Hi Dad, Geoffrey here!";
    }
}
