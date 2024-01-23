package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.ChambreService;
import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.TypeChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id).orElse(null);
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.saveChambre(chambre);
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre updatedChambre) {
        if (chambreService.getChambreById(id).isPresent()) {
            updatedChambre.setIdChambre(id);
            return chambreService.saveChambre(updatedChambre);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }

    @GetMapping("/search")
    public List<Chambre> searchChambres(@RequestParam(required = false) Long numeroChambre, @RequestParam(required = false) TypeChambre type) {
        if (numeroChambre != null && type != null) {
            return chambreService.findChambresByNumeroChambreAndType(numeroChambre, type);
        } else if (numeroChambre != null) {
            return chambreService.findChambresByNumeroChambre(numeroChambre);
        } else if (type != null) {
            return chambreService.findChambresByType(type);
        } else {
            return Collections.emptyList();
        }
    }
}
