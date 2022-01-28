package com.example.homework5.service;

import com.example.homework5.Model.Product;
import com.example.homework5.service.implementation.ProductServiceImpl;
import com.example.homework5.storage.ProductStorage;
import com.example.homework5.utils.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.homework5.TestConstants.FAKE_NAME;
import static com.example.homework5.TestConstants.NAME_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    private ProductDto productDtoFake;
    private ProductDto productDtoExisting;
    private Product productOne;
    private Product fakeProduct;

    @BeforeEach
    void setUp() {
        productDtoFake = new ProductDto(FAKE_NAME, 1);
        productOne = ProductStorage.PRODUCTS.get(NAME_ONE);
        fakeProduct = new Product(productDtoFake);
        productDtoExisting = new ProductDto(NAME_ONE, 2);
    }

    @Test
    void createProduct() {
        final Product product = productService.createProduct(productDtoFake);
        assertEquals(fakeProduct, product);
        assertEquals(ProductStorage.PRODUCTS.size(), 11);
    }

    @Test
    void getProducts() {
        final List<Product> products = productService.getProducts();
        assertEquals(products.size(), 10);
        assertTrue(products.contains(productOne));
    }

    @Test
    void updatePrice() {
        final Product product = productService.updatePrice(productDtoExisting);
        assertEquals(product, product);
        assertEquals(product.getPrice(), productDtoExisting.getPrice());
        assertEquals(ProductStorage.PRODUCTS.size(), 10);
    }

    @Test
    void getProduct() {
        final Product product = productService.getProduct(NAME_ONE);
        assertEquals(product, productOne);
    }

    @Test
    void deleteProduct() {
        final Product product = productService.deleteProduct(NAME_ONE);
        assertEquals(product, productOne);
        assertEquals(ProductStorage.PRODUCTS.size(), 9);

        productService.createProduct(productDtoExisting);
    }
}
