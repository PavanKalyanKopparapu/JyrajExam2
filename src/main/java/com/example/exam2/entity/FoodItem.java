package com.example.exam2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food_items", schema = "Food")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id")
    @JsonProperty("food_item_id")
    Integer foodItemId;

//    @OneToMany(mappedBy = "foodItem")
//    List<OrderItem> foodItems;

    @Column(name = "food_item_name")
    @JsonProperty("food_item_name")
    String foodItemName;

    @Column(name = "price")
    @JsonProperty("price")
    Double price;

    @ManyToOne
    @JoinColumn(name = "food_item_category_id")
    @JsonProperty("food_item_category_id")
    FoodItemCategory foodItemCategory;
}
