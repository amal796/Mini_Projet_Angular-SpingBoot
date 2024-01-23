package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.FoyerService;
import com.example.premierprojettest.model.Foyer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Foyer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoyerController {
    @Autowired
    private final FoyerService FoyerService;

    @Operation(description = "récupérer toutes les foyers de la base de données")
    @GetMapping("/retrieve-all-Foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = FoyerService.getFoyer();
        return listFoyers;
    }

    @PostMapping("/add-Foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        Foyer Foyer = FoyerService.addFoyer(c);
        return Foyer;
    }

    @DeleteMapping("/remove-Foyer/{Foyer-id}")
    public void removeFoyer(@PathVariable("Foyer-id") Long chId) {
        FoyerService.deleteFoyer(chId);
    }

    @PutMapping("/modify-Foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        Foyer Foyer = FoyerService.updateFoyer(c);
        return Foyer;
    }
}
