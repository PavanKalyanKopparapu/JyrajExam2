package com.example.exam2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer", schema = "Sales")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @JsonProperty("customer_id")
    Integer customerId;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    String lastName;

    @Column(name = "username", unique = true)
    @JsonProperty("username")
    String username;

    @Column(name = "email")
    @JsonProperty("email")
    String email;

    @Column(name = "phone")
    @JsonProperty("phone")
    String phone;

    @Column(name = "password")
    @JsonProperty("password")
    String password;


    @Column(name = "registered_date")
    @JsonIgnore
    LocalDateTime registeredDate = LocalDateTime.now();

    @Column(name = "is_logged_in")
    @JsonIgnore
    Boolean isLoggedIn;
}
