package com.example.homework5.service;

import com.example.homework5.Model.Person;
import com.example.homework5.service.implementation.PersonServiceImpl;
import com.example.homework5.storage.PersonStorage;
import com.example.homework5.utils.dto.PersonDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.homework5.TestConstants.FAKE_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl personService;
    private Person personOne;
    private Person personFake;
    private PersonDto personDtoFake;

    @BeforeEach
    void setUp() {
        personOne = PersonStorage.PERSONS.get(1);

        personDtoFake = new PersonDto(FAKE_NAME, 2);
        personFake = new Person(personDtoFake);
    }

    @Test
    void createPerson() {
        final Person person = personService.createPerson(personDtoFake);
        System.out.println(personFake);
        System.out.println(person);
        assertEquals(personFake, person);
        assertEquals(PersonStorage.PERSONS.size(),11);
    }

    @Test
    void getPerson() {
        final Person person = personService.getPerson(1);
        assertEquals(person, personOne);

    }

    @Test
    void updatePhone() {
        final Person person = personService.updatePhone(1,2);
        assertEquals(PersonStorage.PERSONS.get(person.getId()).getPhone(), 2);
    }

    @Test
    void deletePerson() {
        final Person person = personService.deletePerson(1);
        assertEquals(person, personOne);
        assertEquals(PersonStorage.PERSONS.size(),9);
    }

    @Test
    void getPersons() {
        final List<Person> products = personService.getPersons();
        assertEquals(products.size(), 10);
        assertTrue(products.contains(personOne));
    }
}
