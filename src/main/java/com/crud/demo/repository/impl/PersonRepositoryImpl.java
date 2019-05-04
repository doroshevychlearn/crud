package com.crud.demo.repository.impl;

import com.crud.demo.entity.Person;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.crud.demo.repository.PersonRepository;
import org.springframework.stereotype.Repository;
import com.crud.demo.repository.crud.impl.CRUDRepositoryImpl;

@Repository
public class PersonRepositoryImpl extends CRUDRepositoryImpl<Person, Long> implements PersonRepository {
    private static final String TABLE = "person";
    private static final Class<Person> CLASS = Person.class;
    private static final String INSERT_SQL = "insert into " +
            TABLE + " (" +
            "age, " +
            "last_name, " +
            "first_name) " +
            "values (?, ?, ?)";
    private static final String UPDATE_SQL = "update " +
            TABLE + " set " +
            "age = ?, " +
            "last_name = ?, " +
            "first_name = ? where id = ?";

    public PersonRepositoryImpl() {
        super(TABLE, CLASS);
    }

    @Override
    public void save(Person person) {
        if (isNull(person)) {
            throw new IllegalArgumentException("Person must be not null!");
        }
        Long id = person.getId();
        if (nonNull(id) && nonNull(super.getOne(id))) {
            super.save(UPDATE_SQL, person.getAge(), person.getLastName(), person.getFirstName(), id);
        } else {
            super.save(INSERT_SQL, person.getAge(), person.getLastName(), person.getFirstName());
        }
    }
}
