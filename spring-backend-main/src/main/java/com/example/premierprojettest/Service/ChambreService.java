package com.example.premierprojettest.Service;


import com.example.premierprojettest.Respository.ChambreRepository;
import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.TypeChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    public List<Chambre> findChambresByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    public List<Chambre> findChambresByType(TypeChambre type) {
        return chambreRepository.findByType(type);
    }

    public List<Chambre> findChambresByNumeroChambreAndType(Long numeroChambre, TypeChambre type) {
        return chambreRepository.findByNumeroChambreAndType(numeroChambre, type);
    }

}
