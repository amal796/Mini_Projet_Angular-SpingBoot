package com.example.premierprojettest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;

    private Long capaciteFoyer;

    @OneToOne
    @JoinColumn(name = "idUniversite")
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;
}