package com.example.exam2.repository;

import com.example.exam2.entity.FoodItem;
import com.example.exam2.entity.FoodItemCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    FoodItem findByFoodItemName(String foodItemName);

    @Procedure(procedureName = "proc_getByCategory")
    List<FoodItem> getByCategory(@Param("food_category_name") String foodItemCategoryName);

    Page<FoodItem> findAll(Pageable pageable);
}