package com.springbootswagger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeRecord extends  RuntimeException {

    public InvalidEmployeeRecord(String message, Throwable throwable){
        super(message, throwable);
    }

}
