package com.springboot.springbootlearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String hello(){
        return "Welcome to Docker spring";
    }
}
