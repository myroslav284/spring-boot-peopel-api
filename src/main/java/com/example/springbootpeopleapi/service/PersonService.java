package com.example.springbootpeopleapi.service;

import com.example.springbootpeopleapi.dto.PersonRequest;
import com.example.springbootpeopleapi.model.Person;
import jakarta.validation.Valid;

import java.util.List;

public interface PersonService {

    Person savePerson(PersonRequest person);

    Person getPersonById(Long id);
    List<Person> getPeople(String keyword);
    void deletePersonById(Long id);
    Person changePerson(Long id, @Valid PersonRequest updatedPerson);

}
