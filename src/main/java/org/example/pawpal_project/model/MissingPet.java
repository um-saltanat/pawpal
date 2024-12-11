package org.example.pawpal_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "missing_pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MissingPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String description;
    private String lastSeenLocation;
    private LocalDate dateLost;
    private String contactInf0;
}
