package com.example.homework5.service;

import com.example.homework5.Model.Product;
import com.example.homework5.dto.ProductDto;
import com.example.homework5.storage.ProductStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct(final ProductDto dto) {
        if (!ProductStorage.PRODUCTS.containsKey(dto.getName())) {
            final Product product = new Product(dto);
            ProductStorage.PRODUCTS.put(dto.getName(), product);
            return product;
        }
        throw new RuntimeException("PRODUCT ALREADY EXISTS");
    }

    @Override
    public Product updatePrice(final ProductDto dto) {
        this.validateProduct(dto.getName());
        ProductStorage.PRODUCTS.get(dto.getName()).setPrice(dto.getPrice());
        return ProductStorage.PRODUCTS.get(dto.getName());
    }

    @Override
    public Product getProduct(final String name) {
        this.validateProduct(name);
        return ProductStorage.PRODUCTS.get(name);
    }

    @Override
    public Product deleteProduct(final String name) {
        this.validateProduct(name);
        return ProductStorage.PRODUCTS.remove(name);

    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(ProductStorage.PRODUCTS.values());
    }

    private void validateProduct(final String name) {
        if (!ProductStorage.PRODUCTS.containsKey(name)) {
            throw new RuntimeException("PRODUCT NOT FOUND");
        }
    }
}
