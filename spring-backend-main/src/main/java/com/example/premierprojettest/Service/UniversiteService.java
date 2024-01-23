package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.ChambreRepository;
import com.example.premierprojettest.Respository.FoyerRepository;
import com.example.premierprojettest.Respository.UniversiteRepository;
import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.Foyer;
import com.example.premierprojettest.model.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UniversiteService")

public class UniversiteService  implements IUniversiteService{
    private final UniversiteRepository UniversiteRepository ;
    @Autowired
    private FoyerRepository foyerRepository;


    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository) {
        UniversiteRepository = universiteRepository;
    }

    @Override
    public List<Universite> getUniversite() {
        return (List<Universite>) UniversiteRepository.findAll();

    }

   /* @Override
    public Universite addUniversite(Universite universite) {
        return UniversiteRepository.save(universite);
    }*/

    @Override
    public Universite addUniversite(Universite universite) {
        Foyer foyer = universite.getFoyer();

        // Vérifier si le foyer existe
        if (foyer != null) {
            // Vérifier si le foyer a déjà un ID (ce qui signifie qu'il existe en base de données)
            Long foyerId = foyer.getIdFoyer();

            if (foyerId != null) {
                // Si le foyer a un ID, récupérez-le depuis la base de données
                Foyer existingFoyer = foyerRepository.findById(foyerId).orElse(null);
                universite.setFoyer(existingFoyer);
            }
        }

        // Enregistrez l'université
        return UniversiteRepository.save(universite);
    }



    @Override
    public Universite updateUniversite(Universite universite) {
        Long id=universite.getIdUniversite();
        Universite universite1=UniversiteRepository.findById(id).get();
        universite1.setNomUniversite(universite.getNomUniversite());
        universite1.setAdresse(universite.getAdresse());
        universite1.setFoyer(universite.getFoyer());
        return UniversiteRepository.save(universite1);    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {

        return UniversiteRepository.findById(idUniversite).orElse(null);
    }
    @Override
    public void deleteUniversite(Long id) {
        UniversiteRepository.deleteById(id);

    }

    @Override
    public List<Universite> searchUniversites(String nomUniversite) {

        return  UniversiteRepository.findByNomUniversite(nomUniversite);
    }

    public List<Universite> getUniversitesTrieesParAdresse() {
        return UniversiteRepository.findAll(Sort.by(Sort.Direction.ASC, "adresse"));
    }


    public List<Universite> getUniversitesTrieesParNom() {
        return UniversiteRepository.findAll(Sort.by(Sort.Direction.ASC, "nomUniversite"));
    }





}
