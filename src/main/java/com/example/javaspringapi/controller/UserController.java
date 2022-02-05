package com.example.javaspringapi.controller;

import com.example.javaspringapi.entity.UserEntity;
import com.example.javaspringapi.exception.UserAlreadyExist;
import com.example.javaspringapi.exception.UserNotFoundException;
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
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return  ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error");
        }
    }
}
