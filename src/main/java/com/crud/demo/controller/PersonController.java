package com.crud.demo.controller;

import com.crud.demo.dto.PersonDTO;
import com.crud.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok(this.personService.getAllPersons());
    }


    @PostMapping("/")
    public ResponseEntity savePerson(@RequestBody PersonDTO person) {
        this.personService.savePerson(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity updatePerson(@RequestBody PersonDTO person) {
        this.personService.updatePeron(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable(name = "id") Long id) {
        this.personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.personService.getPersonById(id));
    }

}
