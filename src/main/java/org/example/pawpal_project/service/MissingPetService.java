package org.example.pawpal_project.service;

import org.example.pawpal_project.model.MissingPet;
import org.example.pawpal_project.repository.MissingPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissingPetService {
    private final MissingPetRepository missingPetRepository;

    @Autowired
    public MissingPetService(MissingPetRepository missingPetRepository) {
        this.missingPetRepository = missingPetRepository;
    }

    public List<MissingPet> findAll() {
        return missingPetRepository.findAll();
    }

    public MissingPet findById(Long id) {
        return missingPetRepository.findById(id).orElse(null);
    }

    public MissingPet save(MissingPet missingPet) {
        return missingPetRepository.save(missingPet);
    }
}
