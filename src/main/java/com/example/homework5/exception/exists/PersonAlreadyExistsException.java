package com.example.homework5.exception.exists;

import static com.example.homework5.utils.Constants.PERSON_ALREADY_EXISTS;

public class PersonAlreadyExistsException extends AlreadyExistsException{
    public PersonAlreadyExistsException(String lastName){
        super(PERSON_ALREADY_EXISTS + lastName);
    }
}
