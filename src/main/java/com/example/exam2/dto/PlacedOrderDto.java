package com.example.exam2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacedOrderDto {
    @JsonProperty("order_number")
    Integer orderNumber;
    @JsonProperty("customer_name")
    String customerName;
    @JsonProperty("order_datetime")
    String orderDateTime;
    @JsonProperty("order_details")
    Map<String,Map<String, Integer>> orderDetails;

//    @JsonProperty("order_details")
//    Map<String,Integer> orderDetails;
    @JsonProperty("total_quantity")
    Integer totalQuantity;
    @JsonProperty("total_price")
    Double totalPrice;

}
