package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.FoyerRepository;
import com.example.premierprojettest.model.Etudiant;
import com.example.premierprojettest.model.Foyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FoyerService")

public class FoyerService implements IFoyerService{
    private final FoyerRepository FoyerRepository;

    @Autowired
    public FoyerService(FoyerRepository foyerRepository) {
        FoyerRepository = foyerRepository;
    }


    @Override
    public List<Foyer> getFoyer() {
        return (List<Foyer>) FoyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return FoyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        Long id=foyer.getIdFoyer();
        Foyer foyer1=FoyerRepository.findById(id).get();
        foyer1.setCapaciteFoyer(foyer.getCapaciteFoyer());
        foyer1.setNomFoyer(foyer.getNomFoyer());
        return FoyerRepository.save(foyer1);    }

    @Override
    public void deleteFoyer(Long id) {
        FoyerRepository.deleteById(id);

    }
}
