package com.example.AtmWeb.controller;

import com.example.AtmWeb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebControllerUi {

    private final UserService userService;

    public WebControllerUi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/caixa")
    public String mostrarCaixa(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "caixa";
    }
    @GetMapping("caixa/saldo/{id}")
    public String mostrarSaldo(Model model, @PathVariable Long id) {
        model.addAttribute("users", userService.getBalance(id));
        return "saldo";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }



}
