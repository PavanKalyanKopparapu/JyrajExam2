package com.example.exam2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty("username")
    String username;
    @JsonProperty("food_items")
    Map<String, Integer> foodItems;
//    String[] foodItems;
//    @JsonProperty("quantity")
//    Integer[] quantity;
}
