package com.example.premierprojettest.Controller;


import com.example.premierprojettest.Controller.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.premierprojettest.model.Etudiant;
import com.example.premierprojettest.Respository.EtudiantRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.premierprojettest.Service.EtudiantService;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    //get all foyer
    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiant(){
        return etudiantRepository.findAll();
    }
    // Supprimer l'étudiant par ID
    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEtudiant(@PathVariable Long id) {
        // Recherchez l'étudiant par ID
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found with id: " + id));

        // Supprimez l'étudiant de la base de données
        etudiantRepository.delete(etudiant);

        // Préparez la réponse
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        // Retournez une réponse ResponseEntity
        return ResponseEntity.ok(response);
    }

    // Mettre à jour l'étudiant par ID
    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        // Recherchez l'étudiant par ID
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found with id: " + id));

        // Mettez à jour les détails de l'étudiant
        etudiant.setNomEt(etudiantDetails.getNomEt());
        etudiant.setPrenomEt(etudiantDetails.getPrenomEt());
        etudiant.setEcole(etudiantDetails.getEcole());
        etudiant.setCin(etudiantDetails.getCin());
        etudiant.setDateNaissance(etudiantDetails.getDateNaissance());

        // Sauvegardez l'étudiant mis à jour dans la base de données
        Etudiant updatedEtudiant = etudiantRepository.save(etudiant);

        // Retournez une réponse ResponseEntity avec l'étudiant mis à jour
        return ResponseEntity.ok(updatedEtudiant);
    }
    // get etudiant by id rest api
    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found with id: " + id));
        return ResponseEntity.ok(etudiant);
    }

    @PostMapping("/etudiants")
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        try {
            Etudiant savedEtudiant = etudiantRepository.save(etudiant);
            return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
        } catch (Exception e) {
            // Loggez l'exception pour le débogage
            e.printStackTrace();
            return new ResponseEntity<>("Erreur lors de la création de l'étudiant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}