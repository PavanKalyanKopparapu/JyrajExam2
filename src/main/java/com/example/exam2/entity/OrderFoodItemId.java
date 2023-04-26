package com.example.exam2.entity;


import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderFoodItemId implements Serializable {
    Integer order;
    Integer foodItem;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof OrderFoodItemId)) return false;
        OrderFoodItemId o = (OrderFoodItemId) obj;
        return Objects.equals(order,o.order) && Objects.equals(foodItem,o.foodItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order,foodItem);
    }
}
