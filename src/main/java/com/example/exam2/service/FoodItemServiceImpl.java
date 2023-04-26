package com.example.exam2.service;

import com.example.exam2.dto.FoodItemDto;
import com.example.exam2.entity.FoodItem;
import com.example.exam2.entity.FoodItemCategory;
import com.example.exam2.repository.FoodItemCategoryRepository;
import com.example.exam2.repository.FoodItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    FoodItemCategoryRepository foodItemCategoryRepository;
    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    APIClient apiClient;

    @Override
    public String add(FoodItem foodItem) {
        return null;
    }

    @Override
    public FoodItem getById(Integer foodItemId) {
        return null;
    }

    @Override
    public List<FoodItem> getAll() {
        return null;
    }

    @Override
    public String update(Integer foodItemId, FoodItem foodItem) {
        return null;
    }

    @Override
    public String delete(Integer foodItemId) {
        return null;
    }

    @Transactional
    @Cacheable(value = "food_item",key = "#foodItemCategoryName")
    @Override
    public List<FoodItem> getByFoodItemCategoryName(String foodItemCategoryName) {
        FoodItemCategory foodItemCategory = foodItemCategoryRepository.findByFoodItemCategoryName(foodItemCategoryName);
        List<FoodItem> foodItems = foodItemRepository.getByCategory(foodItemCategoryName);
        return foodItems;
    }


    @Override
    public List<FoodItem> getAll(Pageable pageable) {
        return foodItemRepository.findAll(pageable).getContent();
    }

    @Override
    public List<FoodItemDto> getByCategoryName(String foodItemCategoryName) {
        FoodItemCategory foodItemCategory = foodItemCategoryRepository.findByFoodItemCategoryName(foodItemCategoryName);
        List<FoodItem> foodItems = foodItemRepository.getByCategory (foodItemCategoryName);
        List<FoodItemDto> foodItemDtoList = modelMapper.map(foodItems,new TypeToken<List<FoodItemDto>>(){}.getType());
//        List<FoodItemDto> foodItemDtoList = apiClient.getFoodItemsByCategoryName(foodItemCategoryName);
        return foodItemDtoList;
    }
}
