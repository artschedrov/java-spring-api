package com.example.javaspringapi.controller;

import com.example.javaspringapi.entity.UserEntity;
import com.example.javaspringapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public  ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userRepo.save(user);
            return  ResponseEntity.ok("Server is working");
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return  ResponseEntity.ok("Server is working");
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error");
        }
    }
}
