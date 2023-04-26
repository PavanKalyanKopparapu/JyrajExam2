package com.example.exam2.controller;

import com.example.exam2.commonresponse.CommonResponse;
import com.example.exam2.dto.OrderDto;
import com.example.exam2.entity.OrderItem;
import com.example.exam2.service.OrderItemService;
import com.example.exam2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceOrderController {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public CommonResponse placeOrder(@RequestBody OrderDto orderDto) {
        return new CommonResponse(null, HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), orderItemService.placeOrder(orderDto));
    }

    @GetMapping("/getOrderByCustomer")
    public CommonResponse getOrderByCustomerName(@RequestParam("customerName") String customerName) {
        return new CommonResponse(null, HttpStatus.OK, HttpStatus.OK.value(), orderService.getByCustomerName(customerName));
    }

    @PostMapping("/addOrderItem")
    public CommonResponse add(@RequestBody OrderItem orderItem){
        return new CommonResponse(null,HttpStatus.CREATED,HttpStatus.CREATED.value(), orderItemService.add(orderItem));
    }
}
