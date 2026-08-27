package com.project.missingperson.service;

import com.project.missingperson.entity.FoundPerson;
import com.project.missingperson.repository.FoundPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoundPersonService {

    private final FoundPersonRepository foundPersonRepository;

    public FoundPersonService(FoundPersonRepository foundPersonRepository) {
        this.foundPersonRepository = foundPersonRepository;
    }

    public FoundPerson addFoundPerson(FoundPerson person) {
        return foundPersonRepository.save(person);
    }

    public List<FoundPerson> getAllFoundPersons() {
        return foundPersonRepository.findAll();
    }

    public Optional<FoundPerson> getFoundPersonById(Long id) {
        return foundPersonRepository.findById(id);
    }

    public void deleteFoundPerson(Long id) {
        foundPersonRepository.deleteById(id);
    }
}