package com.project.missingperson.service;

import com.project.missingperson.entity.MissingPerson;
import com.project.missingperson.repository.MissingPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissingPersonService {

    private final MissingPersonRepository repository;

    public MissingPersonService(MissingPersonRepository repository) {
        this.repository = repository;
    }

    public MissingPerson savePerson(MissingPerson person) {
        return repository.save(person);
    }

    public List<MissingPerson> getAllPersons() {
        return repository.findAll();
    }
    public MissingPerson getPersonById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public List<MissingPerson> searchPersonByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
    public MissingPerson updatePerson(Long id, MissingPerson updatedPerson) {

        MissingPerson existingPerson = repository.findById(id).orElse(null);

        if (existingPerson != null) {
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setAge(updatedPerson.getAge());
            existingPerson.setGender(updatedPerson.getGender());
            existingPerson.setLocation(updatedPerson.getLocation());
            existingPerson.setDescription(updatedPerson.getDescription());
            existingPerson.setPhoneNumber(updatedPerson.getPhoneNumber());

            return repository.save(existingPerson);
        }

        return null;
    }
    public String deletePerson(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Person deleted successfully";
        }

        return "Person not found";
    }
}