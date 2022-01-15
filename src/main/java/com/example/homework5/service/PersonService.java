package com.example.homework5.service;

import com.example.homework5.Model.Person;
import com.example.homework5.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    Person createPerson(PersonDto person);

    Person getPerson(Integer id);

    Person updatePhone(Integer id, Integer phone);

    Person deletePerson(Integer id);

    List<Person> getPersons();
}
