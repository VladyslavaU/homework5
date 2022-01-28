package com.example.homework5.Model;

import com.example.homework5.storage.ProductStorage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class Cart {
    private final Map<Product, Integer> products = new HashMap<>();
    private Integer sum;

    public Cart() {
        this.sum = 0;
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    public Integer getSum() {
        return this.sum;
    }

    public Cart addProduct(final String productName, final Integer quantity) {
        final Product product = ProductStorage.PRODUCTS.get(productName);
        this.products.computeIfPresent(product,
                (key, val) -> val + quantity);
        this.products.putIfAbsent(product, quantity);
        this.sum += product.getPrice() * quantity;
        return this;
    }

    public Cart deleteProduct(final String productName, final Integer quantity) {
        final Product product = ProductStorage.PRODUCTS.get(productName);
        if (this.products.containsKey(product)) {
            final int difference = this.products.get(product) - quantity;
            if (difference <= 0) {
                this.products.remove(product);
                this.sum -= (quantity + difference) * product.getPrice();
            } else {
                this.products.computeIfPresent(product, (key, val) -> val - quantity);
                sum -= product.getPrice() * quantity;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder productString = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productString.append(entry.getKey().getName())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        productString.append(" total: $").append(sum);
        return productString.toString();
    }
}
