package com.example.premierprojettest.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre type;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String virtualTourURL;

    @ManyToOne
    @JoinColumn(name = "idBloc")
    private Bloc bloc;
}

