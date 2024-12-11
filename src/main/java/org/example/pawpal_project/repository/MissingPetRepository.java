package org.example.pawpal_project.repository;

import org.example.pawpal_project.model.MissingPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissingPetRepository extends JpaRepository<MissingPet, Long> {
}
