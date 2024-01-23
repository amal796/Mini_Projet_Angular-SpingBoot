package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Bloc;

import java.util.List;

public interface IBlocService {

    public List<Bloc> getBloc();
    public Bloc addBloc(Bloc bloc);
    public Bloc updateBloc(Bloc bloc);
    public void deleteBloc(Long id);
    public Bloc findByNomBloc(String nomBloc);
    public Bloc findByIdBloc(Long id);
}
