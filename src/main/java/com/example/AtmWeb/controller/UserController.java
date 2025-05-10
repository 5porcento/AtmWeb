package com.example.AtmWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bank")
@RestController
public class UserController {

    @GetMapping
    public String UserController() {
        return "Hello World";
    }
}
