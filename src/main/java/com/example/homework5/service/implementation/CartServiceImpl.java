package com.example.homework5.service.implementation;

import com.example.homework5.Model.Cart;
import com.example.homework5.Model.Person;
import com.example.homework5.service.abstraction.CartService;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.utils.DataValidator;
import com.example.homework5.utils.dto.ProductQuantityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    @Override
    public Cart addProduct(final Integer personId, int cartNumber, final ProductQuantityDto productQuantityDto) {
        final String name = productQuantityDto.getProductName();
        DataValidator.validateProduct(name);
        DataValidator.validatePerson(personId);
        final Person person = PersonStorage.PERSONS.get(personId);
        DataValidator.validateCart(person, cartNumber);
        return person.getCart(cartNumber).addProduct(name, Math.abs(productQuantityDto.getQuantity()));
    }

    @Override
    public Cart deleteProduct(final Integer personId, final int cartNumber, final ProductQuantityDto productQuantityDto) {
        final String productName = productQuantityDto.getProductName();
        DataValidator.validatePerson(personId);
        DataValidator.validateProduct(productName);
        final Person person = PersonStorage.PERSONS.get(personId);
        DataValidator.validateCart(person, cartNumber);
        return PersonStorage.PERSONS.get(personId).getCart(cartNumber).deleteProduct(productName, Math.abs(productQuantityDto.getQuantity()));
    }

    @Override
    public Cart clear(final Integer personId, final  int cartId) {
        DataValidator.validatePerson(personId);
        final Person person = PersonStorage.PERSONS.get(personId);
        DataValidator.validateCart(person, cartId);
        person.getCart(cartId).getProducts().clear();
        return PersonStorage.PERSONS.get(personId).getCart(cartId);
    }

    @Override
    public Cart getCart(final Integer personId, final int cartId) {
        DataValidator.validatePerson(personId);
        final Person person = PersonStorage.PERSONS.get(personId);
        DataValidator.validateCart(person, cartId);
        return PersonStorage.PERSONS.get(personId).getCart(cartId);
    }
}
