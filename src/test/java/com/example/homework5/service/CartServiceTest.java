package com.example.homework5.service;

import com.example.homework5.Model.Cart;
import com.example.homework5.storage.PersonStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.homework5.TestConstants.FAKE_NAME;
import static com.example.homework5.TestConstants.NAME_ONE;
import static com.example.homework5.TestConstants.PERSON_NOT_FOUND;
import static com.example.homework5.TestConstants.PRODUCT_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    @InjectMocks
    private CartServiceImpl cartService;
    private final static Integer FAKE_ID = 12;
    private final Integer REAL_ID = 1;
    private Exception exception;

    @BeforeEach
    void setUp() {
    }


    @Test
    void addProduct() {
        final Cart cart = cartService.addProduct(REAL_ID, NAME_ONE, 1);
        assertEquals(PersonStorage.PERSONS.get(REAL_ID).getCart(), cart);

        exception = assertThrows(RuntimeException.class, () -> cartService.addProduct(FAKE_ID, NAME_ONE, 1));
        assertEquals(exception.getMessage(), PERSON_NOT_FOUND);

        exception = assertThrows(RuntimeException.class, () -> cartService.addProduct(REAL_ID, FAKE_NAME, 1));
        assertEquals(exception.getMessage(), PRODUCT_NOT_FOUND);
    }

    @Test
    void deleteProduct() {
        cartService.addProduct(REAL_ID, NAME_ONE, 5);

        final Cart cart = cartService.deleteProduct(REAL_ID, NAME_ONE, 1);
        assertEquals(PersonStorage.PERSONS.get(REAL_ID).getCart(), cart);

        exception = assertThrows(RuntimeException.class, () -> cartService.deleteProduct(FAKE_ID, NAME_ONE, 1));
        assertEquals(exception.getMessage(), PERSON_NOT_FOUND);

        exception = assertThrows(RuntimeException.class, () -> cartService.deleteProduct(REAL_ID, FAKE_NAME, 1));
        assertEquals(exception.getMessage(), PRODUCT_NOT_FOUND);
    }

    @Test
    void getCart() {
        final Cart cart = cartService.getCart(REAL_ID);
        assertEquals(PersonStorage.PERSONS.get(REAL_ID).getCart(), cart);

        exception = assertThrows(RuntimeException.class, () -> cartService.getCart(FAKE_ID));
        assertEquals(exception.getMessage(), PERSON_NOT_FOUND);
    }

    @Test
    void clear() {
        final Cart cart = cartService.clear(REAL_ID);
        assertTrue(cart.getProducts().isEmpty());
        assertEquals(PersonStorage.PERSONS.get(REAL_ID).getCart(), cart);

        exception = assertThrows(RuntimeException.class, () -> cartService.clear(FAKE_ID));
        assertEquals(exception.getMessage(), PERSON_NOT_FOUND);
    }
}
