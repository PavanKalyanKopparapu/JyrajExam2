package com.example.exam2.exception;

import com.example.exam2.commonresponse.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public CommonResponse exception(UserNotFoundException userNotFoundException) {
        CommonResponse commonResponse = new CommonResponse(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), null);
        return commonResponse;
    }
}
