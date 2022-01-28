package com.example.homework5.utils.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class ProductQuantityDto {
    @NotEmpty
    private final String productName;
    @NotEmpty
    private final Integer quantity;
}
