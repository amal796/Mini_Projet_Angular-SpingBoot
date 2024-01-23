package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.BlocRepository;
import com.example.premierprojettest.Respository.ChambreRepository;
import com.example.premierprojettest.Respository.FoyerRepository;
import com.example.premierprojettest.Respository.UniversiteRepository;
import com.example.premierprojettest.model.Bloc;

import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.Foyer;
import com.example.premierprojettest.model.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AffectationService {

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

    @Autowired
    public AffectationService(UniversiteRepository universiteRepository, FoyerRepository foyerRepository, BlocRepository blocRepository, ChambreRepository chambreRepository) {
        this.universiteRepository = universiteRepository;
        this.foyerRepository = foyerRepository;
        this.blocRepository = blocRepository;
        this.chambreRepository = chambreRepository;
    }
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Optional<Foyer> foyerOptional = foyerRepository.findById(idFoyer);
        if (foyerOptional.isEmpty()) {
            return null;
        }
        Foyer foyer = foyerOptional.get();

        Universite universite = (Universite) universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            return null;
        }

        // Affecter le foyer à l'université
        universite.setFoyer(foyer);

        // Sauvegarder l'université mise à jour dans la base de données
        universiteRepository.save(universite);

        // Retourner l'université mise à jour
        return universite;
    }

    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        // Rechercher l'université par son identifiant
        Optional<Universite> universiteOptional = universiteRepository.findById(idUniversite);

        if (universiteOptional.isEmpty()) {
            return null;
        }

        Universite universite = universiteOptional.get();
        universite.setFoyer(null);

        // Vous pouvez également sauvegarder l'université mise à jour dans la base de données
        universiteRepository.save(universite);

        // Retourner l'université mise à jour
        return universite;
    }




}






   /* public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Optional<Bloc> optionalBloc = blocRepository.findById(idBloc);

        if (optionalBloc.isPresent()) {
            Bloc bloc = optionalBloc.get();

            List<Chambre> chambres = numChambres.stream()
                    .map(numChambre -> {
                        List<Chambre> optionalChambre = chambreRepository.findByNumeroChambre(numChambre);
                        return optionalChambre.isEmpty() ? null : optionalChambre.get(0);
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            chambres.forEach(chambre -> chambre.setBloc(bloc));
            chambreRepository.saveAll(chambres);

            bloc.setChambres(chambres);
            return blocRepository.save(bloc);
        }

        return null;
    }*/

   /* public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            foyer.setUniversite(universite);

            List<Bloc> blocs = foyer.getBlocs();

            for (Bloc bloc : blocs) {
                bloc.setFoyer(foyer);
            }

            return foyerRepository.save(foyer);
        }

        return null;
    }*/

