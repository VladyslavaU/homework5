package com.example.homework5.Model;

import com.example.homework5.dto.ProductDto;

public class Product {
    private final String name;
    private Integer price;

    public Product(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public Product(ProductDto dto) {
        this(dto.getName(), dto.getPrice());
    }

    public String getName() {
        return name;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product))
            return false;
        Product other = (Product) o;
        return (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        return result;
    }
}
