package com.example.premierprojettest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversite")
    private Long idUniversite;

    private String nomUniversite;

    private String adresse;

    @OneToOne(mappedBy = "universite", cascade = CascadeType.ALL)
    @JoinColumn(name = "idFoyer")
    private Foyer foyer;
}