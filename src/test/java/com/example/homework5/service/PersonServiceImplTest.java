package com.example.homework5.service;

import com.example.homework5.Model.Person;
import com.example.homework5.Model.Product;
import com.example.homework5.dto.PersonDto;
import com.example.homework5.storage.PersonStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.homework5.TestConstants.FAKE_NAME;
import static com.example.homework5.TestConstants.PERSON_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl personService;
    private Person personOne;
    private Person personFake;
    private PersonDto personDtoFake;
    private PersonDto personDtoOne;
    private Exception exception;

    @BeforeEach
    void setUp() {
        personOne = PersonStorage.PERSONS.get(1);
        personDtoOne = new PersonDto(personOne.getLastName(), personOne.getPhone());

        personDtoFake = new PersonDto(FAKE_NAME, 2);
        personFake = new Person(personDtoFake);
    }

    @Test
    void createPerson() {
        final Person person = personService.createPerson(personDtoFake);
        assertEquals(personFake, person);
        assertEquals(PersonStorage.PERSONS.size(),11);

        exception = assertThrows(RuntimeException.class, () -> personService.createPerson(personDtoOne));
        assertEquals("PERSON ALREADY EXISTS", exception.getMessage());
    }

    @Test
    void getPerson() {
        final Person person = personService.getPerson(1);
        assertEquals(person, personOne);

        exception = assertThrows(RuntimeException.class, () -> personService.getPerson(12));
        assertEquals(PERSON_NOT_FOUND, exception.getMessage());
    }

    @Test
    void updatePhone() {
        final Person person = personService.updatePhone(1,2);
        assertEquals(PersonStorage.PERSONS.get(person.getId()).getPhone(), 2);

        exception = assertThrows(RuntimeException.class, () -> personService.getPerson(12));
        assertEquals(PERSON_NOT_FOUND, exception.getMessage());
    }

    @Test
    void deletePerson() {
        final Person person = personService.deletePerson(1);
        assertEquals(person, personOne);
        assertEquals(PersonStorage.PERSONS.size(),9);

        exception = assertThrows(RuntimeException.class, () -> personService.deletePerson(12));
        assertEquals(PERSON_NOT_FOUND, exception.getMessage());
    }

    @Test
    void getPersons() {
        final List<Person> products = personService.getPersons();
        assertEquals(products.size(), 10);
        assertTrue(products.contains(personOne));
    }
}
