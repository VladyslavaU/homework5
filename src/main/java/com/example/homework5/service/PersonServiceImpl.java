package com.example.homework5.service;

import com.example.homework5.Model.Person;
import com.example.homework5.dto.PersonDto;
import com.example.homework5.storage.PersonStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person createPerson(final PersonDto personDto) {
        this.validateDto(personDto);
        final Person person = new Person(personDto);
        if (!PersonStorage.PERSONS.containsValue(person)) {
            PersonStorage.PERSONS.put(person.getId(), person);
            return person;
        }
        throw new RuntimeException("PERSON ALREADY EXISTS");
    }

    @Override
    public Person getPerson(final Integer id) {
        this.validatePerson(id);
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public Person updatePhone(final Integer id, final Integer phone) {
        this.validatePerson(id);
        PersonStorage.PERSONS.get(id).setPhone(phone);
        return PersonStorage.PERSONS.get(id);
    }

    @Override
    public Person deletePerson(final Integer id) {
        this.validatePerson(id);
        return PersonStorage.PERSONS.remove(id);
    }

    @Override
    public List<Person> getPersons() {
        return new ArrayList<>(PersonStorage.PERSONS.values());
    }

    private void validatePerson(final Integer id) {
        if (!PersonStorage.PERSONS.containsKey(id)) {
            throw new RuntimeException("PERSON NOT FOUND");
        }
    }

    private void validateDto(PersonDto personDto){
        if(personDto.getLastName() == null || personDto.getPhone() == null){
            throw new RuntimeException("LAST NAME AND PHONE MUST BE PRESENT");
        }
    }
}
