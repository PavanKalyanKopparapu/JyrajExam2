package com.example.exam2.service;

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
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderItemRepository orderItemRepository;


    @Cacheable(value = "order",key = "#customerName")
    @Override
    public List<PlacedOrderDto> getByCustomerName(String customerName) {
        List<PlacedOrderDto> placedOrderDtoList = new ArrayList<>();
        Customer customer = customerRepository.findByUsername(customerName);
        List<Order> orders = orderRepository.findByCustomer(customer);
        String custName = customer.getFirstName().concat(" ").concat(customer.getLastName());
        ArrayList<Map<String,Map<String,Integer>>> foodItemsList = new ArrayList<>();
        for (int j = 0; j < orders.size(); j++) {
            Integer orderNumber = orders.get(j).getOrderId();
            String orderDate = orders.get(j).getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Integer totalQty = 0;
            Double totalPrice = 0.0;
            OrderItem[] orderItems = orderItemRepository.findByOrder(orders.get(j));
            Map<String,Map<String,Integer>> foodItems = new HashMap<>();
            for (OrderItem orderItem : orderItems) {
                FoodItem foodItem = orderItem.getFoodItem();
                String foodItemName = foodItem.getFoodItemName();
                Integer totQty = orderItem.getQuantity();
                totalQty += totQty;
                Double totPrice = foodItem.getPrice();
                totalPrice += totQty * totPrice;
                foodItems.put(foodItemName, new HashMap<>());
                foodItems.get(foodItemName).put("unit_price", totPrice.intValue());
                foodItems.get(foodItemName).put("quantity", totQty);
                foodItems.get(foodItemName).put("subtotal", totQty * totPrice.intValue());
            }
            foodItemsList.add(foodItems);
            PlacedOrderDto placedOrderDto = new PlacedOrderDto(orderNumber,custName,orderDate,foodItemsList.get(j),totalQty,totalPrice);
            placedOrderDtoList.add(placedOrderDto);
        }
        return placedOrderDtoList;
    }
}
