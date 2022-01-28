package com.example.homework5.controller;

import com.example.homework5.Model.Person;
import com.example.homework5.service.abstraction.PersonService;
import com.example.homework5.utils.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@RequestParam Integer id) {
        return ResponseEntity.ok(service.getPerson(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto person) {
        return ResponseEntity.ok(service.createPerson(person));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePhone(@RequestParam Integer id, @RequestBody PersonDto personDto) {
        return ResponseEntity.ok(service.updatePhone(id, personDto.getPhone()));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> deletePerson(@RequestParam Integer id) {
        return ResponseEntity.ok(service.deletePerson(id));
    }

    @RequestMapping("/all")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(service.getPersons());
    }

    @RequestMapping("/addCart")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> addCart(@RequestParam Integer id) {
        return ResponseEntity.ok(service.addCart(id));
    }

    @RequestMapping("/deleteCart")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> deleteCart(@RequestParam Integer id, int cartNumber) {
        return ResponseEntity.ok(service.removeCart(id, cartNumber));
    }
}
