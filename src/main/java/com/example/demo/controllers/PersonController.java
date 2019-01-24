package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

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
        Collection<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(!persons.isEmpty() ? persons.iterator().next(): new Person());
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Collection<Person>> deletePerson(@RequestBody String id) {
        personRepository.deleteById(id);
        return ResponseEntity.ok(personRepository.findAll());
    }
}
