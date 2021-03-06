package com.sungwook.exception.statuscode;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The Student is not exist")
public class NotExistStudent extends RuntimeException{
    private String message;
    public NotExistStudent(String message) {
        super(message);
        this.message = message;
    }
}
