package com.example.exam2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(OrderFoodItemId.class)
@Table(name = "order_items", schema = "Sales")
public class OrderItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    @JsonProperty("order")
    Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "food_item_id",referencedColumnName = "food_item_id")
    @JsonProperty("food_item")
    FoodItem foodItem;

    @Column(name = "quantity")
    @JsonProperty("quantity")
    Integer quantity;

    @Column(name = "total_price")
    @JsonProperty("total_price")
    Double totalPrice;
}
