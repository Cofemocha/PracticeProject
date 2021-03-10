package com.lkp.jwtexample.exp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyException extends  ArithmeticException{
    private String messgae;
    private int status;
    public MyException(){

    }
    public MyException(String message, int status){
        this.messgae= message;
        this.status=status;
    }

}
