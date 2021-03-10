package com.lkp.jwtexample.exp;


import com.lkp.jwtexample.controller.BaseController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController{

    @ExceptionHandler(MyException.class)
    public ResponseResult myExceptionHandler(MyException ex){
        return  renderError(ex);
    }

}
