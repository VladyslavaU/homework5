package com.example.homework5.service.implementation;

import com.example.homework5.Model.Person;
import com.example.homework5.service.abstraction.PersonService;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.utils.DataValidator;
import com.example.homework5.utils.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    @Override
    public Person createPerson(final PersonDto personDto) {
        final Person person = new Person(personDto);
        DataValidator.validateNewPerson(person);
        PersonStorage.PERSONS.put(person.getId(), person);
        return person;
    }

    @Override
    public Person getPerson(final Integer id) {
        DataValidator.validatePerson(id);
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public Person updatePhone(final Integer id, final Integer phone) {
        DataValidator.validatePerson(id);
        PersonStorage.PERSONS.get(id).setPhone(phone);
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public Person deletePerson(final Integer id) {
        DataValidator.validatePerson(id);
        return PersonStorage.PERSONS.remove(id);
    }

    @Override
    public Person addCart(final Integer id) {
        DataValidator.validatePerson(id);
        PersonStorage.PERSONS.get(id).addCart();
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public Person removeCart(final Integer id, final int cartId) {
        DataValidator.validatePerson(id);
        PersonStorage.PERSONS.get(id).deleteCart(cartId);
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public List<Person> getPersons() {
        return new ArrayList<>(PersonStorage.PERSONS.values());
    }

}
