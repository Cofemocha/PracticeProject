package com.lkp.jwtexample.controller;

import com.lkp.jwtexample.exp.ResponseResult;
import com.lkp.jwtexample.exp.MyException;

public class BaseController {

    public <T>ResponseResult renderError(MyException e){
        return ResponseResult.builder().message(e.getMessgae()).status(e.getStatus()).build();
    }
    public <T>ResponseResult renderSuccess(T content){
        return  ResponseResult.builder().message("login success").status(200).content(content).build();
    }
    public <T>ResponseResult renderSuccess(){
        return  ResponseResult.builder().message("request success").status(200).build();
    }
}
