package com.example.springbootpeopleapi.service;

import com.example.springbootpeopleapi.dto.PersonRequest;
import com.example.springbootpeopleapi.model.Person;
import com.example.springbootpeopleapi.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person savePerson(PersonRequest personRequest) {
        Person person = Person.build(0L, personRequest.getName(), personRequest.getSurname(),
                personRequest.getAge());
        personRepository.save(person);
        return person;
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Person not found with id " + id));
    }

    @Override
    public List<Person> getPeople(String keyword) {
        if (keyword != null) {
            return personRepository.findPeopleBySurnameOrName(keyword);
        } else return personRepository.findAll();

    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person changePerson(Long id, PersonRequest updatedPersonRequest) {
        Person existingPerson = getPersonById(id);

        // Update the details
        existingPerson.setName(updatedPersonRequest.getName());
        existingPerson.setSurname(updatedPersonRequest.getSurname());
        existingPerson.setAge(updatedPersonRequest.getAge());

        // Save the updated person
        personRepository.save(existingPerson);
        return existingPerson;
    }
}
