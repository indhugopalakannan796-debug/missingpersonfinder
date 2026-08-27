package com.project.missingperson.controller;

import com.project.missingperson.entity.MissingPerson;
import com.project.missingperson.service.MissingPersonService;
import com.project.missingperson.service.PhotoStorageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin("*")
public class MissingPersonController {

    private final MissingPersonService service;
    private final PhotoStorageService photoStorageService;

    public MissingPersonController(
            MissingPersonService service,
            PhotoStorageService photoStorageService) {
        this.service = service;
        this.photoStorageService = photoStorageService;
    }

    // Add person without photo
    @PostMapping("/add")
    public MissingPerson addPerson(@Valid @RequestBody MissingPerson person) {
        return service.savePerson(person);
    }

    // Add person with photo
    @PostMapping("/add-with-photo")
    public MissingPerson addPersonWithPhoto(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("gender") String gender,
            @RequestParam("location") String location,
            @RequestParam("description") String description,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("photo") MultipartFile photo
    ) throws Exception {

        MissingPerson person = new MissingPerson();

        person.setName(name);
        person.setAge(age);
        person.setGender(gender);
        person.setLocation(location);
        person.setDescription(description);
        person.setPhoneNumber(phoneNumber);

        String photoPath = photoStorageService.savePhoto(photo);
        person.setPhotoPath(photoPath);

        return service.savePerson(person);
    }

    // Get person by ID
    @GetMapping("/{id}")
    public MissingPerson getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    // Update person
    @PutMapping("/update/{id}")
    public MissingPerson updatePerson(
            @PathVariable Long id,
            @RequestBody MissingPerson person) {

        return service.updatePerson(id, person);
    }

    // Delete person
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }

    // Get all persons
    @GetMapping("/all")
    public List<MissingPerson> getAllPersons() {
        return service.getAllPersons();
    }

    // Search person by name
    @GetMapping("/search/{name}")
    public List<MissingPerson> searchPersonByName(
            @PathVariable String name) {

        return service.searchPersonByName(name);
    }
}