package com.project.missingperson.service;

import com.project.missingperson.entity.MissingPerson;
import com.project.missingperson.entity.FoundPerson;
import com.project.missingperson.repository.MissingPersonRepository;
import com.project.missingperson.repository.FoundPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MissingPersonRepository missingPersonRepository;
    private final FoundPersonRepository foundPersonRepository;

    public MatchService(
            MissingPersonRepository missingPersonRepository,
            FoundPersonRepository foundPersonRepository) {

        this.missingPersonRepository = missingPersonRepository;
        this.foundPersonRepository = foundPersonRepository;
    }

    public String matchPersons(Long missingId, Long foundId) {

        MissingPerson missingPerson =
                missingPersonRepository.findById(missingId)
                        .orElse(null);

        FoundPerson foundPerson =
                foundPersonRepository.findById(foundId)
                        .orElse(null);

        if (missingPerson == null || foundPerson == null) {
            return "Person not found";
        }

        int score = 0;

        if (missingPerson.getGender()
                .equalsIgnoreCase(foundPerson.getGender())) {
            score += 30;
        }

        if (Math.abs(
                missingPerson.getAge() - foundPerson.getAge()) <= 2) {
            score += 30;
        }

        if (missingPerson.getLocation()
                .equalsIgnoreCase(foundPerson.getFoundLocation())) {
            score += 40;
        }

        return "Match Score: " + score + "%";
    }
}