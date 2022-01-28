package com.example.homework5.exception.exists;

import static com.example.homework5.utils.Constants.PRODUCT_ALREADY_EXISTS;

public class ProductAlreadyExistsException extends AlreadyExistsException{
    public ProductAlreadyExistsException(String name){
        super(PRODUCT_ALREADY_EXISTS + name);
    }
}
