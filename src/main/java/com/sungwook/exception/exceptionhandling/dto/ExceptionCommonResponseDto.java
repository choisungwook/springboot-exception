package com.sungwook.exception.exceptionhandling.dto;

import org.springframework.http.HttpStatus;

public class ExceptionCommonResponseDto {
    private HttpStatus status;
    private String message;

    public ExceptionCommonResponseDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
