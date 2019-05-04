package com.crud.demo.service;

import java.util.Set;
import com.crud.demo.dto.PersonDTO;

public interface PersonService {

    void deletePerson(Long id);

    Set<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    void savePerson(PersonDTO personDTO);

    void updatePeron(PersonDTO personDTO);

}
