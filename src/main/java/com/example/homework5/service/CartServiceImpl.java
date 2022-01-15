package com.example.homework5.service;

import com.example.homework5.Model.Cart;
import com.example.homework5.Model.Product;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.storage.ProductStorage;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public Cart addProduct(final Integer personId, final String productName, final Integer quantity) {
        this.validatePerson(personId);
        this.validateProduct(productName);
        return PersonStorage.PERSONS.get(personId).getCart().addProduct(productName, Math.abs(quantity));
    }

    @Override
    public Cart deleteProduct(Integer personId, String productName, int quantity) {
        this.validatePerson(personId);
        this.validateProduct(productName);
        final Product product = ProductStorage.PRODUCTS.get(productName);
        if(PersonStorage.PERSONS.get(personId).getCart().getProducts().containsKey(product)) {
            return PersonStorage.PERSONS.get(personId).getCart().deleteProduct(productName, Math.abs(quantity));
        }
        throw new RuntimeException("PRODUCT NOT FOUND IN THE CART");
    }

    @Override
    public Cart getCart(Integer personId) {
        this.validatePerson(personId);
        return PersonStorage.PERSONS.get(personId).getCart();
    }


    @Override
    public Cart clear(Integer personId) {
        this.validatePerson(personId);
        PersonStorage.PERSONS.get(personId).getCart().getProducts().clear();
        return PersonStorage.PERSONS.get(personId).getCart();
    }

    private void validatePerson(Integer personId) {
        if (!PersonStorage.PERSONS.containsKey(personId)) {
            throw new RuntimeException("PERSON NOT FOUND");
        }
    }

    private void validateProduct(String productName) {
        if (!ProductStorage.PRODUCTS.containsKey(productName)) {
            throw new RuntimeException("PRODUCT NOT FOUND");
        }
    }
}
