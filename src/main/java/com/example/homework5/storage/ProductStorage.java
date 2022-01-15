package com.example.homework5.storage;

import com.example.homework5.Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductStorage {
    public static final Map<String, Product> PRODUCTS = ProductStorage.addDefaultProducts();

    private static Map<String, Product> addDefaultProducts() {
        Map<String, Product> PRODUCTS = new HashMap<>();
        PRODUCTS.put("NameOne", new Product("NameOne", 1));
        PRODUCTS.put("NameTwo", new Product("NameTwo", 2));
        PRODUCTS.put("NameThree", new Product("NameThree", 3));
        PRODUCTS.put("NameFour", new Product("NameFour", 4));
        PRODUCTS.put("NameFive", new Product("NameFive", 5));
        PRODUCTS.put("NameSix", new Product("NameSix", 6));
        PRODUCTS.put("NameSeven", new Product("NameSeven", 7));
        PRODUCTS.put("NameEight", new Product("NameEight", 8));
        PRODUCTS.put("NameNine", new Product("NameNine", 9));
        PRODUCTS.put("NameTen", new Product("NameTen", 10));
        return PRODUCTS;
    }
}
