package com.example.exam2.service;

import com.example.exam2.dto.OrderDto;
import com.example.exam2.dto.PlacedOrderDto;
import com.example.exam2.entity.OrderItem;

public interface OrderItemService {
    PlacedOrderDto placeOrder(OrderDto orderDto);

    OrderItem add(OrderItem orderItem);
}
