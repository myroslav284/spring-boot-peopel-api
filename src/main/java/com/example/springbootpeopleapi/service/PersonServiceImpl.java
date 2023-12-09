package com.example.springbootpeopleapi.service;

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
    public void savePerson(Person person) {
        personRepository.save(person);
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
        } else return (List<Person>) personRepository.findAll();

    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void changePerson(Long id, Person updatedPerson) {
        Person existingPerson = getPersonById(id);

        // Update the details
        existingPerson.setName(updatedPerson.getName());
        existingPerson.setSurname(updatedPerson.getSurname());
        existingPerson.setAge(updatedPerson.getAge());

        // Save the updated person
        personRepository.save(existingPerson);
    }
}