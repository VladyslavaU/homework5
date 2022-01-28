package com.example.homework5.service.abstraction;

import com.example.homework5.Model.Person;
import com.example.homework5.utils.dto.PersonDto;

import java.util.List;

public interface PersonService {

    Person createPerson(PersonDto person);

    Person getPerson(Integer id);

    Person updatePhone(Integer id, Integer phone);

    Person deletePerson(Integer id);

    List<Person> getPersons();

    Person addCart(Integer id);

    Person removeCart(Integer id, int cartNumber);
}
