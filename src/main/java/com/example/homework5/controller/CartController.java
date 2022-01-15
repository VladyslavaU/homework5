package com.example.homework5.controller;

import com.example.homework5.Model.Cart;
import com.example.homework5.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/cart")
public class CartController {
    @Autowired
    private CartService service;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@RequestParam Integer id) {
        return ResponseEntity.ok(service.getCart(id));
    }

    @RequestMapping("/add")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestParam Integer id, @RequestParam String productName, @RequestParam Integer quantity) {
        return ResponseEntity.ok(service.addProduct(id, productName, quantity).toString());
    }

    @RequestMapping("/delete")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id, @RequestParam String productName, @RequestParam Integer quantity) {
        return ResponseEntity.ok(service.deleteProduct(id, productName, quantity).toString());
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> clearCart(@RequestParam Integer id) {
        return ResponseEntity.ok(service.clear(id));
    }
}
