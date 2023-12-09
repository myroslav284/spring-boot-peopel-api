package com.example.springbootpeopleapi.controller;

import com.example.springbootpeopleapi.model.Person;
import com.example.springbootpeopleapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
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
    public Person savePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
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
