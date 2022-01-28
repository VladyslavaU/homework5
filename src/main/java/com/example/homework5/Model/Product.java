package com.example.homework5.Model;

import com.example.homework5.utils.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class Product {
    private final String name;
    @EqualsAndHashCode.Exclude
    private Integer price;

    public Product(ProductDto dto) {
        this(dto.getName(), dto.getPrice());
    }
}
