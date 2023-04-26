package com.example.exam2.service;

import com.example.exam2.dto.PlacedOrderDto;
import com.example.exam2.entity.Order;

import java.util.List;

public interface OrderService {

    List<PlacedOrderDto> getByCustomerName(String customerName);
}
