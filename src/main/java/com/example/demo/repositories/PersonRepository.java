package com.example.demo.repositories;

import com.example.demo.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface PersonRepository  extends PagingAndSortingRepository<Person, String> {
    Person findFirst();
    Collection<Person> findAll();
}
