package com.example.exam2.repository;


import com.example.exam2.entity.FoodItem;
import com.example.exam2.entity.Order;
import com.example.exam2.entity.OrderFoodItemId;
import com.example.exam2.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderFoodItemId> {
    OrderItem[] findByOrder(Order order);
}