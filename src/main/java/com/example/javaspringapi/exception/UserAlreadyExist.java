package com.example.javaspringapi.exception;

public class UserAlreadyExist extends Exception {
    public  UserAlreadyExist(String message) {
        super(message);
    }
}
