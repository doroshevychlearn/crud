package com.crud.demo.service.impl;

import com.crud.demo.dto.PersonDTO;
import com.crud.demo.entity.Person;
import com.crud.demo.repository.PersonRepository;
import com.crud.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static org.springframework.beans.BeanUtils.*;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void deletePerson(Long id) {

    }

    @Override
    public Set<PersonDTO> getAllPersons() {
        return null;
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void savePerson(PersonDTO personDTO) {

    }

    @Override
    public Person getOne(Long id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PersonDTO getPersonById(Long id) {
        PersonDTO personDTO = new PersonDTO();
        copyProperties(this.personRepository.getOne(id), personDTO);
        return personDTO;
    }

}
