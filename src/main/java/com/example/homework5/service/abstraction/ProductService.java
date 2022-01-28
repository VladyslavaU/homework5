package com.example.homework5.service.abstraction;

import com.example.homework5.Model.Product;
import com.example.homework5.utils.dto.ProductDto;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto product);

    Product updatePrice(ProductDto product);

    Product getProduct(String name);

    Product deleteProduct(String name);

    List<Product> getProducts();
}
