package com.crud.demo.service.impl;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import com.crud.demo.dto.PersonDTO;
import com.crud.demo.entity.Person;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.crud.demo.service.PersonService;
import org.springframework.stereotype.Service;
import com.crud.demo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

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
        this.personRepository.delete(id);
    }

    @Override
    public Set<PersonDTO> getAllPersons() {
        List<Person> people = this.personRepository.findAll();
        if (isNull(people)) {
            people = new ArrayList<>();
        }
        return people.stream().map(person -> PersonDTO.builder()
                .id(person.getId())
                .age(person.getAge())
                .lastName(person.getLastName())
                .firstName(person.getFirstName())
                .build()).collect(Collectors.toSet());
    }

    @Override
    public void savePerson(PersonDTO personDTO) {
        Person person = Person.builder()
                .id(personDTO.getId())
                .age(personDTO.getAge())
                .lastName(personDTO.getLastName())
                .firstName(personDTO.getFirstName())
                .build();
        this.personRepository.save(person);
    }

    @Override
    public void updatePeron(PersonDTO personDTO) {
        Person person = this.personRepository.getOne(personDTO.getId());
        if (nonNull(person)) {
            person = Person.builder()
                    .id(personDTO.getId())
                    .age(personDTO.getAge())
                    .lastName(personDTO.getLastName())
                    .firstName(personDTO.getFirstName())
                    .build();
            this.personRepository.save(person);
        } else {
            throw new IllegalArgumentException("The person does not exist!");
        }
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        PersonDTO personDTO = new PersonDTO();
        Person person = this.personRepository.getOne(id);
        if (nonNull(person)) {
            personDTO = PersonDTO.builder()
                    .id(person.getId())
                    .age(person.getAge())
                    .lastName(person.getLastName())
                    .firstName(person.getFirstName())
                    .build();
        }
        return personDTO;
    }

}
