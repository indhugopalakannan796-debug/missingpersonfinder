package com.project.missingperson.repository;

import com.project.missingperson.entity.FoundPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundPersonRepository extends JpaRepository<FoundPerson, Long> {

}