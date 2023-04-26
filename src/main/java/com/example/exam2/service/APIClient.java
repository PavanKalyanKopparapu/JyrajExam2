package com.example.exam2.service;

import com.example.exam2.dto.FoodItemDto;
import com.example.exam2.entity.FoodItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "FOOD-ITEM-SERVICE",url = "http://localhost:8080")
public interface APIClient {
    @GetMapping(value = "/api/foodItem")
    List<FoodItemDto> getFoodItemsByCategoryName(@RequestParam("category_name") String categoryName);
}
