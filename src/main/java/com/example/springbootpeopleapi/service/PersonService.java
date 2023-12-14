package com.example.springbootpeopleapi.service;

import com.example.springbootpeopleapi.dto.PersonRequest;
import com.example.springbootpeopleapi.model.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(PersonRequest person);

    Person getPersonById(Long id);
    List<Person> getPeople(String keyword);
    void deletePersonById(Long id);
    void changePerson(Long id, Person updatedPerson);

}
