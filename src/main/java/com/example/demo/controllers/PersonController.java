package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    final String FIRST_PERSON_VORNAME = "Max";

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<Person> registerPerson(@RequestBody Person person){
        personRepository.save(person);
        return ResponseEntity.ok(person);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getAllPersons() {
        Collection<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @RequestMapping(path = "/first", method = RequestMethod.GET)
    public ResponseEntity<Person> getFirstPerson() {
        Person person = personRepository.findFirstByVorname(FIRST_PERSON_VORNAME);
        return ResponseEntity.ok(person);
    }
}
