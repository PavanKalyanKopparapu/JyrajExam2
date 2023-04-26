package com.example.exam2.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders", schema = "Sales")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonProperty("order_id")
    Integer orderId;

//    @OneToMany(mappedBy = "order")
//    List<OrderItem> orders;

    @Column(name = "order_date")
    @JsonProperty("order_date")
    LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty("customer_id")
    Customer customer;

    public Order(LocalDateTime orderDate, Customer customer) {
        this.orderDate = orderDate;
        this.customer = customer;
    }
}
