package com.project.missingperson.controller;

import com.project.missingperson.entity.FoundPerson;
import com.project.missingperson.service.FoundPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/found-persons")
@CrossOrigin("*")
public class FoundPersonController {

    private final FoundPersonService foundPersonService;

    public FoundPersonController(FoundPersonService foundPersonService) {
        this.foundPersonService = foundPersonService;
    }

    @PostMapping
    public ResponseEntity<FoundPerson> addFoundPerson(
            @RequestBody FoundPerson person) {

        FoundPerson savedPerson =
                foundPersonService.addFoundPerson(person);

        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping
    public ResponseEntity<List<FoundPerson>> getAllFoundPersons() {

        return ResponseEntity.ok(
                foundPersonService.getAllFoundPersons()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundPerson> getFoundPersonById(
            @PathVariable Long id) {

        return foundPersonService.getFoundPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoundPerson(
            @PathVariable Long id) {

        foundPersonService.deleteFoundPerson(id);

        return ResponseEntity.ok(
                "Found person deleted successfully"
        );
    }
}