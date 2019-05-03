package com.crud.demo.repository.impl;

import com.crud.demo.entity.Person;
import com.crud.demo.repository.PersonRepository;
import com.crud.demo.repository.crud.impl.CRUDRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl extends CRUDRepositoryImpl<Person, Long> implements PersonRepository {

    private static final String TABLE = "person";
    private static final Class CLASS = Person.class;

    public PersonRepositoryImpl() {
        super(TABLE, CLASS);
    }
}
