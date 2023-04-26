package com.example.exam2.repository;

import com.example.exam2.entity.FoodItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemCategoryRepository extends JpaRepository<FoodItemCategory, Integer> {
    FoodItemCategory findByFoodItemCategoryName(String foodItemCategoryName);
}