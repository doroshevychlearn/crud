package com.crud.demo.service;

import com.crud.demo.dto.PersonDTO;
import com.crud.demo.entity.Person;
import com.crud.demo.repository.crud.CRUDRepository;

import java.util.Set;

public interface PersonService extends CRUDRepository<Person, Long> {

    void deletePerson(Long id);

    Set<PersonDTO> getAllPersons();

    void deletePerson(Person person);

    PersonDTO getPersonById(Long id);

    void savePerson(PersonDTO personDTO);

}
