package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant editEtudiant(Etudiant etudiant) throws RuntimeException;

    void deleteEtudiant(Long idEtudiant);

    List<Etudiant> retrieveAll();
}
