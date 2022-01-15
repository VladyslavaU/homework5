package com.example.homework5.dto;

public class ProductDto {

    private String name;
    private Integer price;

    public ProductDto(final String name, final Integer price) {
        this.name = name;
        this.price = price;
    }

    public ProductDto(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return price;
    }
}
