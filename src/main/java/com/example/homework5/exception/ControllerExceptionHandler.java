package com.example.homework5.exception;

import com.example.homework5.exception.exists.AlreadyExistsException;
import com.example.homework5.exception.notfound.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.example.homework5.controller"})
@RequiredArgsConstructor
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExists(AlreadyExistsException e) {
        return new ResponseEntity<>(
                e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
    }
}

