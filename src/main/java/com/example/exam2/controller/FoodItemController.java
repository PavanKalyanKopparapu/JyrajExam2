package com.example.exam2.controller;

import com.example.exam2.commonresponse.CommonResponse;
import com.example.exam2.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @GetMapping("/getFoodItemByCategory")
    public CommonResponse getFoodItemByCategoryName(@RequestParam("foodItemByCategoryName") String foodItemByCategoryName) {
        return new CommonResponse(null, HttpStatus.OK, HttpStatus.OK.value(), foodItemService.getByFoodItemCategoryName(foodItemByCategoryName));
    }

    @GetMapping("/getByCategory")
    public CommonResponse getByCategoryName(@RequestParam("foodItemByCategoryName") String foodItemByCategoryName) {
        return new CommonResponse(null, HttpStatus.OK, HttpStatus.OK.value(), foodItemService.getByCategoryName(foodItemByCategoryName));
    }

    @GetMapping("/getAll")
    public CommonResponse getAll(Pageable pageable){
        return new CommonResponse(null,HttpStatus.OK,HttpStatus.OK.value(),foodItemService.getAll(pageable));
    }
}
