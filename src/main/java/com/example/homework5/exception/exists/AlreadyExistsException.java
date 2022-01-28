package com.example.homework5.exception.exists;

import com.example.homework5.exception.ApplicationException;

public class AlreadyExistsException extends ApplicationException {
    public AlreadyExistsException(String message){
        super(message);
    }
}
