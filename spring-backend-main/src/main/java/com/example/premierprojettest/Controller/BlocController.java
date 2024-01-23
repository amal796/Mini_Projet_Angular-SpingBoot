package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.BlocService;
import com.example.premierprojettest.model.Bloc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/Bloc")
public class BlocController {

    @Autowired
    private final BlocService BlocService;

    @GetMapping("/retrieve-all-Blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = BlocService.getBloc();
        return listBlocs;
    }
    @GetMapping("/retrieve-Bloc/{Bloc-nom}")
    public Bloc retrieveBloc(@PathVariable("Bloc-nom") String nom) {
        Bloc Bloc = BlocService.findByNomBloc(nom);
        return Bloc;
    }
    @GetMapping("/retrieve-Bloc/{Bloc-id}")
    public Bloc retrieveBlocById(@PathVariable("Bloc-id") Long id) {
        Bloc Bloc = BlocService.findByIdBloc(id);
        return Bloc;
    }
    @PostMapping("/add-Bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        Bloc Bloc = BlocService.addBloc(c);
        return Bloc;
    }

    @DeleteMapping("/remove-Bloc/{Bloc-id}")
    public void removeBloc(@PathVariable("Bloc-id") Long chId) {
        BlocService.deleteBloc(chId);
    }

    @PutMapping("/modify-Bloc/{Bloc-id}")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        Bloc Bloc = BlocService.updateBloc(c);
        return Bloc;
    }

}
