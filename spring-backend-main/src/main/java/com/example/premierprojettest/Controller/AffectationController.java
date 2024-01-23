package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.AffectationService;
import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/affectation")
public class AffectationController {
    private final AffectationService affectationService;

    @Autowired
    public AffectationController(AffectationService affectationService) {
        this.affectationService = affectationService;
    }

    @PostMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        Universite universiteDesaffectee = affectationService.desaffecterFoyerAUniversite(idUniversite);

        if (universiteDesaffectee != null) {
            return ResponseEntity.ok(universiteDesaffectee);
        } else {
            // Gérer le cas où l'université n'a pas été trouvée
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public ResponseEntity<Universite> affecterFoyerAUniversite(
            @PathVariable Long idFoyer,
            @PathVariable String nomUniversite) {

        Universite universiteAffectee = affectationService.affecterFoyerAUniversite(idFoyer, nomUniversite);

        if (universiteAffectee != null) {
            return ResponseEntity.ok(universiteAffectee);
        } else {
            // Gérer le cas où l'université n'a pas été trouvée ou l'affectation a échoué
            return ResponseEntity.notFound().build();
        }
    }






}

