package com.project.missingperson.controller;

import com.project.missingperson.entity.MissingPerson;
import com.project.missingperson.service.MissingPersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin("*")
public class MissingPersonController {

    private final MissingPersonService service;

    public MissingPersonController(MissingPersonService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public MissingPerson addPerson(@Valid @RequestBody MissingPerson person) {
        return service.savePerson(person);
    }

    @GetMapping("/{id}")
    public MissingPerson getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @PutMapping("/update/{id}")
    public MissingPerson updatePerson(@PathVariable Long id,
                                      @RequestBody MissingPerson person) {
        return service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }

    @GetMapping("/all")
    public List<MissingPerson> getAllPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/search/{name}")
    public List<MissingPerson> searchPersonByName(@PathVariable String name) {
        return service.searchPersonByName(name);
    }
}