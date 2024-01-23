package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> getFoyer();
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyer(Long id);
}
