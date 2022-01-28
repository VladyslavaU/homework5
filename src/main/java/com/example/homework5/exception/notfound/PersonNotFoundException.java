package com.example.homework5.exception.notfound;

import static com.example.homework5.utils.Constants.PERSON_NOT_FOUND;

public class PersonNotFoundException extends ResourceNotFoundException{
    public PersonNotFoundException(String id){
        super(PERSON_NOT_FOUND + id);
    }
}
