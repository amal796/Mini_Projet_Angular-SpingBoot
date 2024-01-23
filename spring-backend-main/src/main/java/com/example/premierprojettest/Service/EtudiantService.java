package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.EtudiantRepository;
import com.example.premierprojettest.model.Etudiant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EtudiantService implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        if (etudiant.getNomEt() == null || etudiant.getNomEt().isEmpty() ||
                etudiant.getPrenomEt() == null || etudiant.getPrenomEt().isEmpty()) {
            throw new IllegalArgumentException("Nom et Prénom cannot be empty");
        }

        try {
            return etudiantRepository.save(etudiant);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add etudiant", e);
        }
    }

    @Override
    public Etudiant editEtudiant(Etudiant etudiant) throws RuntimeException {
        if (etudiant.getIdEtudiant() == null) {
            throw new IllegalArgumentException("Etudiant ID cannot be null");
        }
        if (etudiant.getNomEt() == null || etudiant.getNomEt().isEmpty() ||
                etudiant.getPrenomEt() == null || etudiant.getPrenomEt().isEmpty()) {
            throw new IllegalArgumentException("Nom et Prénom cannot be empty");
        }

        try {
            return etudiantRepository.save(etudiant);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update etudiant", e);
        }
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(idEtudiant);

        etudiant.ifPresent(e -> {
            etudiantRepository.delete(e);
            log.info("Etudiant with id " + idEtudiant + " has been deleted");
        });
    }

    @Override
    public List<Etudiant> retrieveAll() {
        return etudiantRepository.findAll();
    }
}