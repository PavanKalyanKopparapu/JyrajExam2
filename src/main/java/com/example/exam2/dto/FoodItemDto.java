package com.example.exam2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {
    @JsonProperty(value = "food_item_name")
    String foodItemName;
    @JsonProperty(value = "price")
    Double price;
    @JsonProperty(value = "food_item_category_name")
    String foodItemCategoryName;
}
