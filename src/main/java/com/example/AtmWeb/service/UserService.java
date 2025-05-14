package com.example.AtmWeb.service;

import com.example.AtmWeb.entity.User;
import com.example.AtmWeb.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> findUserById(Long id) {
        return ResponseEntity.ok(userRepository.findById(id)
                .orElse(null));
    }

    public ResponseEntity<BigDecimal> getBalance(Long id) {
        return userRepository.findById(id).map(user -> ResponseEntity.ok(user.getBalance()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<BigDecimal> deposit(Long id, BigDecimal amount) {
        return userRepository.findById(id).map(user ->{
            user.setBalance(user.getBalance().add(amount));
            userRepository.save(user);
            return ResponseEntity.ok(user.getBalance());
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<BigDecimal> withdraw(Long id, BigDecimal amount) {
        return userRepository.findById(id).map(user -> {
            user.setBalance(user.getBalance().subtract(amount));
            userRepository.save(user);
            return ResponseEntity.ok(user.getBalance());
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
