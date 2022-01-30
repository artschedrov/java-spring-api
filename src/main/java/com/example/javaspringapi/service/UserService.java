package com.example.javaspringapi.service;

import com.example.javaspringapi.entity.UserEntity;
import com.example.javaspringapi.exception.UserAlreadyExist;
import com.example.javaspringapi.exception.UserNotFoundException;
import com.example.javaspringapi.model.User;
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

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();

        if(userRepo.findById(id).get() == null) {
            throw  new UserNotFoundException("User not found");
        }

        return User.toModel(user);
    }
}
