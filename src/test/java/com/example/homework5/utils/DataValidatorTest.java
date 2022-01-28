package com.example.homework5.utils;

import com.example.homework5.Model.Person;
import com.example.homework5.exception.exists.PersonAlreadyExistsException;
import com.example.homework5.exception.exists.ProductAlreadyExistsException;
import com.example.homework5.exception.notfound.CartNotFoundException;
import com.example.homework5.exception.notfound.PersonNotFoundException;
import com.example.homework5.exception.notfound.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.homework5.TestConstants.FAKE_ID;
import static com.example.homework5.TestConstants.FAKE_NAME;
import static com.example.homework5.TestConstants.ID;
import static com.example.homework5.TestConstants.NAME_ONE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void validatePerson() {
        assertDoesNotThrow(() -> DataValidator.validatePerson(ID));

        assertThrows(PersonNotFoundException.class, () -> DataValidator.validatePerson(FAKE_ID));
    }

    @Test
    void validateNewPerson() {
        assertDoesNotThrow(() -> DataValidator.validateNewPerson(new Person(FAKE_NAME, 1)));

        assertThrows(PersonAlreadyExistsException.class, () -> DataValidator.validateNewPerson(new Person(NAME_ONE, 1)));
    }

    @Test
    void validateProduct() {
        assertDoesNotThrow(() -> DataValidator.validateProduct(NAME_ONE));

        assertThrows(ProductNotFoundException.class, () -> DataValidator.validateProduct(FAKE_NAME));
    }

    @Test
    void validateNewProduct() {
        assertDoesNotThrow(() -> DataValidator.validateNewProduct(FAKE_NAME));

        assertThrows(ProductAlreadyExistsException.class, () -> DataValidator.validateNewProduct(NAME_ONE));
    }

    @Test
    void validateCart() {
        final Person person = new Person(NAME_ONE, 1);
        assertDoesNotThrow(() -> DataValidator.validateCart(person, 0));

        assertThrows(CartNotFoundException.class, () -> DataValidator.validateCart(person, 1));
    }
}
