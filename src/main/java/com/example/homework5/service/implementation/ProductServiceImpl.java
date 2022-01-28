package com.example.homework5.service.implementation;

import com.example.homework5.Model.Product;
import com.example.homework5.service.abstraction.ProductService;
import com.example.homework5.storage.ProductStorage;
import com.example.homework5.utils.DataValidator;
import com.example.homework5.utils.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct(final ProductDto dto) {
        DataValidator.validateNewProduct(dto.getName());
        final Product product = new Product(dto);
        ProductStorage.PRODUCTS.put(product.getName(), product);
        return product;
    }

    @Override
    public Product updatePrice(final ProductDto dto) {
        final String name = dto.getName();
        DataValidator.validateProduct(name);
        ProductStorage.PRODUCTS.get(name).setPrice(dto.getPrice());
        return ProductStorage.PRODUCTS.get(name);
    }

    @Override
    public Product getProduct(final String name) {
        DataValidator.validateProduct(name);
        return ProductStorage.PRODUCTS.get(name);
    }

    @Override
    public Product deleteProduct(final String name) {
        return ProductStorage.PRODUCTS.remove(name);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(ProductStorage.PRODUCTS.values());
    }
}
