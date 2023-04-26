package com.example.exam2.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {
    String msg;

    @Override
    public String getMessage() {
        return msg;
    }
}
