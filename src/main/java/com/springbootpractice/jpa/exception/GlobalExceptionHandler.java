package com.springbootpractice.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrResp(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
