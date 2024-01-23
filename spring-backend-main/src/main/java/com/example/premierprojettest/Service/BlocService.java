package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.BlocRepository;
import com.example.premierprojettest.model.Bloc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service("BlocService")
public class BlocService implements IBlocService {
    private final BlocRepository BlocRepository;

    @Autowired
    public BlocService(BlocRepository blocRepository) {
        BlocRepository = blocRepository;
    }

    @Override
    public List<Bloc> getBloc() {
        return (List<Bloc>) BlocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return BlocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        Long id=bloc.getIdBloc();
        Bloc bloc1=BlocRepository.findById(id).get();
        bloc1.setNomBloc(bloc.getNomBloc());
        bloc1.setCapaciteBloc(bloc.getCapaciteBloc());
        bloc1.setFoyer(bloc.getFoyer());
        return BlocRepository.save(bloc1);
    }

    @Override
    public void deleteBloc(Long id) {
        BlocRepository.deleteById(id);
    }

    @Override
    public Bloc findByNomBloc(String nomBloc) {
        return (Bloc) BlocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public Bloc findByIdBloc(Long id) {
        return  BlocRepository.findBlocByIdBloc(id);    }


   /* @Override
    public Bloc AjouterBoc(Bloc Bloc) {
        Bloc.setCapaciteBloc(10L);
        Bloc.setNomBloc("A");
        return BlocRepository.save(Bloc);
    }

    @Override
    public List<Bloc> getBlocByCapacite(Long capacite) {
        List<Bloc> blocs = (List<Bloc>) BlocRepository.findAll();
        List<Bloc> blocByCapacite= new ArrayList<>();
        for (Bloc bloc:blocs)
        {
            if(bloc.getCapaciteBloc()==capacite)
                blocByCapacite.add(bloc);
        }
        return blocByCapacite;

        return BlocRepository.findByCapaciteBlocAndNomBloc(capacite , "a");
    }*/
}