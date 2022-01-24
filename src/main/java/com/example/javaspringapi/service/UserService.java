package com.example.javaspringapi.service;

import com.example.javaspringapi.entity.UserEntity;
import com.example.javaspringapi.exception.UserAlreadyExist;
import com.example.javaspringapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExist("User already exists");
        }
        return userRepo.save(user);
    }
}
