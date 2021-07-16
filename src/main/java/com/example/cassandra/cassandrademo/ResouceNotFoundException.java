package com.example.cassandra.cassandrademo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ResponseBody
public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(String message) {
        super(message);
    }
}