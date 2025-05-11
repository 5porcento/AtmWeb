package com.example.AtmWeb.controller;

import com.example.AtmWeb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/caixa")
    public String mostrarCaixa(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "caixa"; // thymeleaf HTML
    }


}
