package com.example.exam2.service;

import com.example.exam2.dto.FoodItemDto;
import com.example.exam2.entity.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodItemService {
    String add(FoodItem foodItem);
    FoodItem getById(Integer foodItemId);
    List<FoodItem> getAll();
    String update(Integer foodItemId, FoodItem foodItem);
    String delete(Integer foodItemId);
    List<FoodItem> getByFoodItemCategoryName(String foodCategoryName);
    List<FoodItem> getAll(Pageable pageable);
    List<FoodItemDto> getByCategoryName(String foodCategoryName);
}
