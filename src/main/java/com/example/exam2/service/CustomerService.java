package com.example.exam2.service;

import com.example.exam2.entity.Customer;

import java.util.List;

public interface CustomerService {
    String add(Customer customer);
    Customer getById(Integer customerId);
    List<Customer> getAll();
    String update(Integer customerId, Customer customer);

    String delete(Integer customerId);
}
