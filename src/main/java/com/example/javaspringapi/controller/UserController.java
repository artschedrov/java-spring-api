package com.example.javaspringapi.controller;

import com.example.javaspringapi.entity.UserEntity;
import com.example.javaspringapi.exception.UserAlreadyExist;
import com.example.javaspringapi.repository.UserRepo;
import com.example.javaspringapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public  ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return  ResponseEntity.ok("User has been created");
        } catch (UserAlreadyExist e){
          return ResponseEntity.badRequest().body(e.getMessage());
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
