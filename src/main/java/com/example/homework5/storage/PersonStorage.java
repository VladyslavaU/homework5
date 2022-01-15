package com.example.homework5.storage;

import com.example.homework5.Model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonStorage {
    public static final Map<Integer, Person> PERSONS = PersonStorage.addDefaultPersons();

    private static Map<Integer, Person> addDefaultPersons() {
        Map<Integer, Person> PERSONS = new HashMap<>();
        PERSONS.put(1, new Person("NameOne", 1));
        PERSONS.put(2, new Person("NameTwo", 2));
        PERSONS.put(3, new Person("NameThree", 3));
        PERSONS.put(4, new Person("NameFour", 4));
        PERSONS.put(5, new Person("NameFive", 5));
        PERSONS.put(6, new Person("NameSix", 6));
        PERSONS.put(7, new Person("NameSeven", 7));
        PERSONS.put(8, new Person("NameEight", 8));
        PERSONS.put(9, new Person("NameNine", 9));
        PERSONS.put(10, new Person("NameTen", 1));
        return PERSONS;
    }
}
