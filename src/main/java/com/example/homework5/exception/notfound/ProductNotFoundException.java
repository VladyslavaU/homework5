package com.example.homework5.exception.notfound;

import static com.example.homework5.utils.Constants.PRODUCT_NOT_FOUND;

public class ProductNotFoundException extends ResourceNotFoundException{
    public ProductNotFoundException(String name){
        super(PRODUCT_NOT_FOUND + name);
    }
}
