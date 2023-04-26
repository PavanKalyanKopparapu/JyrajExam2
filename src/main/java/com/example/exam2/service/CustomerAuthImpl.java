package com.example.exam2.service;

import com.example.exam2.dto.CustomerDto;
import com.example.exam2.entity.Customer;
import com.example.exam2.exception.UserNotFoundException;
import com.example.exam2.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Slf4j
@Service
public class CustomerAuthImpl implements CustomerAuth {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Cacheable(value = "customer")
    @Override
    public String register(CustomerDto customerDto) {
        if (!customerRepository.existsByPhoneOrEmail(customerDto.getPhone(), customerDto.getEmail())) {
            Customer customer = modelMapper.map(customerDto, Customer.class);
            String username = customer.getFirstName() + "@" + UUID.randomUUID().toString().substring(0, 3);
            customer.setUsername(username);
            customer.setRegisteredDate(LocalDateTime.now());
            customer.setIsLoggedIn(false);
            customerRepository.save(customer);
            return "Registered Successfully, Here's your username " + username;
        } else {
            return "Already Registered";
        }
    }

    @Cacheable(value = "customer",key = "{#username,#password}")
    @Override
    public String login(String username, String password) {
        if (customerRepository.existsByUsernameAndPassword(username, password)) {
            Customer customer = customerRepository.findByUsername(username);
            customer.setIsLoggedIn(true);
            customerRepository.save(customer);
            return "Logged in successfully";
        } else
            throw new UserNotFoundException("User not found");
    }

}
