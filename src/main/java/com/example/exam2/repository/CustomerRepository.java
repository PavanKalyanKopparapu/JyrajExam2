package com.example.exam2.repository;

import com.example.exam2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByPhoneOrEmail(String phone, String email);

    Customer findByUsername(String username);

}