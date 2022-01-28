package com.example.homework5.controller;

import com.example.homework5.Model.Cart;
import com.example.homework5.service.abstraction.CartService;
import com.example.homework5.utils.dto.ProductQuantityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@RequestParam Integer personId, @RequestParam int cartNumber) {
        return ResponseEntity.ok(service.getCart(personId, cartNumber));
    }

    @RequestMapping("/add")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestParam Integer id, @RequestParam int cartNumber, @RequestBody ProductQuantityDto productQuantityDto) {
        return ResponseEntity.ok(service.addProduct(id, cartNumber, productQuantityDto).toString());
    }

    @RequestMapping("/delete")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id, @RequestParam int cartNumber, @RequestBody ProductQuantityDto productQuantityDto) {
        return ResponseEntity.ok(service.deleteProduct(id, cartNumber, productQuantityDto).toString());
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> clearCart(@RequestParam Integer id, @RequestParam int cartId) {
        return ResponseEntity.ok(service.clear(id, cartId));
    }
}
