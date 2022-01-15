package com.example.homework5.service;

import com.example.homework5.Model.Cart;

public interface CartService {
    Cart addProduct(Integer personId, String productName, Integer quantity);

    Cart deleteProduct(Integer personId, String productName, int quantity);

    Cart getCart(Integer personId);

    Cart clear(Integer personId);
}
