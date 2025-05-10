package com.example.AtmWeb.controller;

import com.example.AtmWeb.entity.User;
import com.example.AtmWeb.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/bank")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<BigDecimal> getBalanceUsers(@PathVariable Long id) {
        return userService.getBalance(id);
    }

}
