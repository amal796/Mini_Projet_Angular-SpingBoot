package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Reservation;
import com.example.premierprojettest.model.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getUniversite();
    public Universite addUniversite(Universite universite);
    public Universite updateUniversite(Universite universite);
    public void deleteUniversite(Long id);
    //public List<Universite> getUniversiteByidChambre(Long ChambreId);
    public Universite getUniversiteById(Long idUniversite);
    public List<Universite> searchUniversites(String nomUniversite);
    public List<Universite> getUniversitesTrieesParAdresse();
    public List<Universite> getUniversitesTrieesParNom();

}
