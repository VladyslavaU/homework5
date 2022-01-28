package com.example.homework5.Model;

import com.example.homework5.utils.dto.PersonDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Person {
    @EqualsAndHashCode.Exclude
    private final Integer id;
    private final String lastName;
    @EqualsAndHashCode.Exclude
    private Integer phone;
    @EqualsAndHashCode.Exclude
    private final List<Cart> carts = new ArrayList<>();
    @EqualsAndHashCode.Exclude
    private static Integer generatedId = 0;
    @EqualsAndHashCode.Exclude
    private int cartCount = 0;

    public Person(final String lastName, final Integer phone) {
        this.id = ++generatedId;
        this.lastName = lastName;
        this.phone = phone;
        this.addCart();
    }

    public Person(PersonDto personDto) {
        this(personDto.getLastName(), personDto.getPhone());
    }

    public void addCart() {
        this.carts.add(new Cart());
        this.cartCount++;
    }

    public void deleteCart(final int id) {
        if (this.carts.size() > 1) {
            this.carts.remove(id);
            this.cartCount--;
        }
    }

    public Cart getCart(final int id) {
        return this.carts.get(id);
    }
}
