package com.example.homework5.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.homework5.TestConstants.NAME_ONE;
import static com.example.homework5.TestConstants.NAME_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        cart.addProduct(NAME_ONE, 1);
        cart.addProduct(NAME_TWO, 1);

    }

    @Test
    void addProduct() {
        cart.addProduct(NAME_ONE, 1);
        cart.addProduct(NAME_ONE,2);
        cart.addProduct(NAME_TWO, 1);

        assertEquals(cart.getProducts().size(), 2);
        assertEquals(cart.getSum(), 8);
    }

    @Test
    void deleteProduct() {
        cart.deleteProduct(NAME_ONE, 1);
        assertEquals(1, cart.getProducts().size());
        assertEquals(2, cart.getSum());
        cart.deleteProduct(NAME_TWO, 3);
        System.out.println(cart);
        assertEquals(0, cart.getProducts().size());
        assertEquals(0, cart.getSum());
    }
}
