package com.kgisl.sb101.service;

import java.util.List;

import com.kgisl.sb101.entity.Person;

public interface PersonService {
 
    List<Person> getAllPersons();
 
    Person createPerson(Person person);
 
    Person getPersonById(int id);
 
    Person updatePerson(int id, Person updatedPerson);
 
    void deletePerson(int id);
}
