package com.example.springbootpeopleapi.repository;

import com.example.springbootpeopleapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE CONCAT(p.surname, ' ', p.name) LIKE %:term%")
    List<Person> findPeopleBySurnameOrName(@Param("term") String term);


}
