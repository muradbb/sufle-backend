package com.example.demo.exceptions;

public class LimitPassedException extends RuntimeException {

    public LimitPassedException(String message){
        super(message);
    }

}
