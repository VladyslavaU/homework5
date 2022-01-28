package com.example.homework5.utils.dto;

public class ProductDto {

    private final String name;
    private final Integer price;

    public ProductDto(final String name, final Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return price;
    }
}
