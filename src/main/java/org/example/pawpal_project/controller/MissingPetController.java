package org.example.pawpal_project.controller;

import org.example.pawpal_project.model.MissingPet;
import org.example.pawpal_project.service.MissingPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missing-pets")
public class MissingPetController {

    private final MissingPetService missingPetService;

    @Autowired
    public MissingPetController(MissingPetService missingPetService) {
        this.missingPetService = missingPetService;
    }

    @GetMapping
    public List<MissingPet> getAllMissingPets() {
        return missingPetService.findAll();
    }

    @GetMapping("/{id}")
    public MissingPet getMissingPetById(@PathVariable Long id) {
        return missingPetService.findById(id);
    }

    @PostMapping
    public MissingPet createMissingPet(@RequestBody MissingPet missingPet) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return missingPetService.save(missingPet);
    }
}
