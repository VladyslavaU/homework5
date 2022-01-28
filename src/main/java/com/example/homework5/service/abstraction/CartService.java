package com.example.homework5.service.abstraction;

import com.example.homework5.Model.Cart;
import com.example.homework5.utils.dto.ProductQuantityDto;

public interface CartService {
    Cart addProduct(Integer personId, int cartId, ProductQuantityDto productQuantityDto);

    Cart deleteProduct(Integer personId, int cartId, ProductQuantityDto productQuantityDto);

    Cart getCart(Integer personId, int cartNumber);

    Cart clear(Integer personId, int cartNumber);
}
