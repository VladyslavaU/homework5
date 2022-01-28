package com.example.homework5.exception.notfound;

import static com.example.homework5.utils.Constants.CART_NOT_FOUND;

public class CartNotFoundException extends ResourceNotFoundException{
    public CartNotFoundException(String id){
        super(CART_NOT_FOUND + id);
    }
}
