package com.project.missingperson.repository;
import java.util.List;

import com.project.missingperson.entity.MissingPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissingPersonRepository extends JpaRepository<MissingPerson, Long> {
    List<MissingPerson> findByNameContainingIgnoreCase(String name);

}
