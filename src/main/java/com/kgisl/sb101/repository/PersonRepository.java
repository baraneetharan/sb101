package com.kgisl.sb101.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb101.entity.Person;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Integer> {
}