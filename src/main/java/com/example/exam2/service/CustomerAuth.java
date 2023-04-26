package com.example.exam2.service;

import com.example.exam2.dto.CustomerDto;

public interface CustomerAuth {
    String register(CustomerDto customerDto);

    String login(String username, String password);
}
