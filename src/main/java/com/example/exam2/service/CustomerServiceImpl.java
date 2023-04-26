package com.example.exam2.service;

import com.example.exam2.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public String add(Customer customer) {
        return null;
    }

    @Override
    public Customer getById(Integer customerId) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public String update(Integer customerId, Customer customer) {
        return null;
    }

    @Override
    public String delete(Integer customerId) {
        return null;
    }
}
