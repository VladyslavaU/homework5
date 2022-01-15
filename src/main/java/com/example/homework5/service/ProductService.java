package com.example.homework5.service;

import com.example.homework5.Model.Product;
import com.example.homework5.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto product);

    Product updatePrice(ProductDto product);

    Product getProduct(String name);

    Product deleteProduct(String name);

    List<Product> getProducts();
}
