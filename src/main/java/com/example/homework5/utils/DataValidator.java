package com.example.homework5.utils;

import com.example.homework5.Model.Person;
import com.example.homework5.exception.exists.PersonAlreadyExistsException;
import com.example.homework5.exception.exists.ProductAlreadyExistsException;
import com.example.homework5.exception.notfound.CartNotFoundException;
import com.example.homework5.exception.notfound.PersonNotFoundException;
import com.example.homework5.exception.notfound.ProductNotFoundException;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.storage.ProductStorage;

public class DataValidator {
    public static void validatePerson(final Integer id) {
        if (!PersonStorage.PERSONS.containsKey(id)) {
            throw new PersonNotFoundException(id.toString());
        }
    }

    public static void validateNewPerson(final Person person) {
        if (PersonStorage.PERSONS.containsValue(person)) {
            throw new PersonAlreadyExistsException(person.getLastName());
        }
    }

    public static void validateProduct(final String name) {
        if (!ProductStorage.PRODUCTS.containsKey(name)) {
            throw new ProductNotFoundException(name);
        }
    }

    public static void validateNewProduct(final String name) {
        if (ProductStorage.PRODUCTS.containsKey(name)) {
            throw new ProductAlreadyExistsException(name);
        }
    }

    public static void validateCart(final Person person, final int id) {
        if (person.getCartCount() - 1 < id) {
            throw new CartNotFoundException(String.valueOf(id));
        }
    }
}
