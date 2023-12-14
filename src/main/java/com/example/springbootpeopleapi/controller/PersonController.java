package com.example.springbootpeopleapi.controller;

import com.example.springbootpeopleapi.dto.PersonRequest;
import com.example.springbootpeopleapi.model.Person;
import com.example.springbootpeopleapi.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    @ResponseBody
    Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/")
    @ResponseBody
    List<Person> getPeople(@Param("keyword") String keyword) {
        return personService.getPeople(keyword);
    }

    @PostMapping("/savePerson")
    @ResponseBody
    public Person savePerson(@RequestBody @Valid PersonRequest personRequest) {

        return personService.savePerson(personRequest);
    }
    @PutMapping("/changePerson/{id}")
    @ResponseBody
    public Person changePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        personService.changePerson(id, updatedPerson);
        return  getPersonById(id);
    }

    @DeleteMapping("/deletePerson/{id}")
    @ResponseBody
    public Map<String, String> deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted successfully!");

        return response;
    }
}
