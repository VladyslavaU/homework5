package com.example.homework5.service;

import com.example.homework5.Model.Cart;
import com.example.homework5.service.implementation.CartServiceImpl;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.utils.dto.ProductQuantityDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.homework5.TestConstants.CART_ID;
import static com.example.homework5.TestConstants.ID;
import static com.example.homework5.TestConstants.NAME_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    @InjectMocks
    private CartServiceImpl cartService;
    private ProductQuantityDto productQuantityDto;
    @BeforeEach
    void setUp() {
        productQuantityDto = new ProductQuantityDto(NAME_ONE, 1);
    }


    @Test
    void addProduct() {
        final Cart cart = cartService.addProduct(ID, CART_ID, productQuantityDto);
        assertEquals(PersonStorage.PERSONS.get(ID).getCart(CART_ID), cart);
    }

    @Test
    void deleteProduct() {
        cartService.addProduct(ID, CART_ID,  productQuantityDto);

        final Cart cart = cartService.deleteProduct(ID, CART_ID, productQuantityDto);
        assertEquals(PersonStorage.PERSONS.get(ID).getCart(CART_ID), cart);
    }

    @Test
    void getCart() {
        final Cart cart = cartService.getCart(ID, CART_ID);
        assertEquals(PersonStorage.PERSONS.get(ID).getCart(CART_ID), cart);
    }

    @Test
    void clear() {
        final Cart cart = cartService.clear(ID, CART_ID);
        assertTrue(cart.getProducts().isEmpty());
        assertEquals(PersonStorage.PERSONS.get(ID).getCart(CART_ID), cart);
    }
}
