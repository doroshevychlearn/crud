package com.crud.demo.controller;

import com.crud.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.personService.getPersonById(id));
    }

}
