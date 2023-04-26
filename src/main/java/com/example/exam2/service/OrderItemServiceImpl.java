package com.example.exam2.service;

import com.example.exam2.dto.OrderDto;
import com.example.exam2.dto.PlacedOrderDto;
import com.example.exam2.entity.Customer;
import com.example.exam2.entity.FoodItem;
import com.example.exam2.entity.Order;
import com.example.exam2.entity.OrderItem;
import com.example.exam2.repository.CustomerRepository;
import com.example.exam2.repository.FoodItemRepository;
import com.example.exam2.repository.OrderItemRepository;
import com.example.exam2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;


    /**
     * @param orderDto Request body to get order from user
     * @return PlaceOrderDto In response user will get summary of order.
     */
    @Cacheable(value = "order")
    @Override
    public PlacedOrderDto placeOrder(OrderDto orderDto) {
        Customer customer = customerRepository.findByUsername(orderDto.getUsername());
        Order order = orderRepository.save(new Order(LocalDateTime.now(), customer));
        Integer totalQty = 0;
        Double totPrice = 0.0;
        String[] foodItems = orderDto.getFoodItems().keySet().toArray(new String[orderDto.getFoodItems().size()]);
        Integer[] quantity = orderDto.getFoodItems().values().toArray(new Integer[orderDto.getFoodItems().size()]);
        Map<String, Map<String, Integer>> priceMap = new HashMap<>();
        for (int i = 0; i < foodItems.length; i++) {
            FoodItem foodItem = foodItemRepository.findByFoodItemName(foodItems[i]);
            priceMap.put(foodItems[i], new HashMap<>());
            priceMap.get(foodItems[i]).put("unit_price", foodItem.getPrice().intValue());
            priceMap.get(foodItems[i]).put("quantity", quantity[i]);
            priceMap.get(foodItems[i]).put("subtotal", quantity[i] * foodItem.getPrice().intValue());
            Integer qty = quantity[i];
            totalQty += qty;
            Double totalPrice = foodItem.getPrice() * qty;
            totPrice += totalPrice;
            OrderItem oi = new OrderItem(order, foodItem, qty, totalPrice);
            orderItemRepository.save(oi);
        }
        PlacedOrderDto placedOrderDto = new PlacedOrderDto(order.getOrderId(), customer.getFirstName().concat(" ").concat(customer.getLastName()), order.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), priceMap, totalQty, totPrice);
        return placedOrderDto;
    }

    @Override
    public OrderItem add(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
