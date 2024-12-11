package org.example.pawpal_project.repository;

import org.example.pawpal_project.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
