package com.example.exam2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "food_items_categories", schema = "Food")
public class FoodItemCategory {
    @Id
    @Column(name = "food_item_category_id")
    @JsonProperty("food_item_category_id")
    Integer foodItemCategoryId;

    @Column(name = "food_item_category_name")
    @JsonProperty("food_item_category_name")
    String foodItemCategoryName;
}
