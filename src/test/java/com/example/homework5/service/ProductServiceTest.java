package com.example.homework5.service;

import com.example.homework5.Model.Product;
import com.example.homework5.dto.ProductDto;
import com.example.homework5.storage.ProductStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.homework5.TestConstants.FAKE_NAME;
import static com.example.homework5.TestConstants.NAME_ONE;
import static com.example.homework5.TestConstants.PRODUCT_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    private ProductDto productDtoFake;
    private ProductDto productDtoExisting;
    private Product productOne;
    private Product fakeProduct;
    private Exception exception;

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

        exception = assertThrows(RuntimeException.class, () -> productService.createProduct(productDtoExisting));
        assertEquals(exception.getMessage(), "PRODUCT ALREADY EXISTS");
    }

    @Test
    void updatePrice() {
        final Product product = productService.updatePrice(productDtoExisting);
        assertEquals(product, product);
        assertEquals(product.getPrice(), productDtoExisting.getPrice());
        assertEquals(ProductStorage.PRODUCTS.size(), 10);

        exception = assertThrows(RuntimeException.class, () -> productService.updatePrice(productDtoFake));
        assertEquals(exception.getMessage(), PRODUCT_NOT_FOUND);
    }

    @Test
    void getProduct() {
        final Product product = productService.getProduct(NAME_ONE);
        assertEquals(product, productOne);

        exception = assertThrows(RuntimeException.class, () -> productService.getProduct(FAKE_NAME));
        assertEquals(exception.getMessage(), PRODUCT_NOT_FOUND);
    }

    @Test
    void deleteProduct() {
        final Product product = productService.deleteProduct(NAME_ONE);
        assertEquals(product, productOne);
        assertEquals(ProductStorage.PRODUCTS.size(), 9);

        exception = assertThrows(RuntimeException.class, () -> productService.deleteProduct(FAKE_NAME));
        assertEquals(exception.getMessage(), PRODUCT_NOT_FOUND);
    }

    @Test
    void getProducts() {
        final List<Product> products = productService.getProducts();
        assertEquals(products.size(), 10);
        assertTrue(products.contains(productOne));
    }
}
