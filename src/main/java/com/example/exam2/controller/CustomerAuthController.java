package com.example.exam2.controller;

import com.example.exam2.commonresponse.CommonResponse;
import com.example.exam2.dto.CustomerDto;
import com.example.exam2.service.CustomerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class CustomerAuthController {

    @Autowired
    CustomerAuth customerAuth;

    @PostMapping("/register")
    public CommonResponse register(@RequestBody CustomerDto customerDto) {
        return new CommonResponse(null, HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), customerAuth.register(customerDto));
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return new CommonResponse(null, HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), customerAuth.login(username, password));
    }
}
