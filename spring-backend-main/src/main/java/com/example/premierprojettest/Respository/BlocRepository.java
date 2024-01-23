package com.example.premierprojettest.Respository;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    public List<Bloc>  findByNomBloc(String name);
    public Bloc findBlocByIdBloc(Long id);

   /* @Query("SELECT b FROM Bloc b WHERE b.nomBloc=:nomBloc")
    List<Bloc> listBlocParNom(@Param("nomBloc") String nomBloc);


    @Modifying
    @Query("update Bloc b set b.nomBloc=:nomBloc where b.idBloc=:idBloc")
    int updateBlocByNom(@Param("nomBloc") String nomBloc , @Param("idBloc") Long idBloc);

    @Modifying
    @Query("DELETE FROM Bloc b WHERE b.idBloc =: idBloc")
    int deleteByIdBloc(@Param("idBloc") Long idBloc);*/
}
