package com.example.homework5.exception.notfound;

import com.example.homework5.exception.ApplicationException;

public class ResourceNotFoundException extends ApplicationException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
