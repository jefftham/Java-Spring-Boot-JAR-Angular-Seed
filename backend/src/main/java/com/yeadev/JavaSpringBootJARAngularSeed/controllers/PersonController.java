package com.yeadev.JavaSpringBootJARAngularSeed.controllers;

import com.yeadev.JavaSpringBootJARAngularSeed.jpa.PersonJpaRepository;
import com.yeadev.JavaSpringBootJARAngularSeed.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class PersonController {

    PersonJpaRepository repository;

    @Autowired
    public PersonController(PersonJpaRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Person getPersonById(@PathVariable long id) {
        return repository.findById(id);
    }

}
