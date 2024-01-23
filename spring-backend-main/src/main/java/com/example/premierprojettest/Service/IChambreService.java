package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Chambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> getChambre();
    public Chambre addChambre(Chambre chambre);
    public Chambre updateChambre(Chambre chambre);
    public void deleteChambre(Long id);
    public Chambre findByNumeroChambre(Long numero);
    //public List<Chambre> findChambresByType(Chambre.TypeChambre type);
    //public List<Chambre> findChambresByNumeroChambreAndType(Long numeroChambre, Chambre.TypeChambre type);

}
