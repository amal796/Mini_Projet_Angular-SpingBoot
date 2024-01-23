package com.example.premierprojettest.Respository;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
   /* @Query("SELECT F FROM Foyer F WHERE F.nomFoyer=:nomFoyer")
    List<Bloc> ListFoyerByNom(@Param("nomFoyer") String nomFoyer);


    @Modifying
    @Query("update Foyer F set F.nomFoyer=:nomFoyer where F.idFoyer=:idFoyer")
    int updateFoyerByNumero(@Param("nomFoyer") String nomFoyer , @Param("idFoyer") Long idFoyer);

    @Modifying
    @Query("DELETE FROM Foyer F WHERE F.idFoyer =: idFoyer")
    int deleteByIdFoyer(@Param("idFoyer") Long idFoyer);*/
}
