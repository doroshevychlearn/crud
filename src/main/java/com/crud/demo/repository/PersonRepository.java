package com.crud.demo.repository;

import com.crud.demo.entity.Person;
import com.crud.demo.repository.crud.CRUDRepository;

public interface PersonRepository extends CRUDRepository<Person, Long> {
}
