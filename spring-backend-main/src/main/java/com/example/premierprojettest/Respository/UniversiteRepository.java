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

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    List<Universite> findByNomUniversite(String nomUniversite);


  /*  @Query("SELECT u FROM Universite u WHERE u.adresse=:adresse")
    List<Universite> listUniversiteParAdresse(@Param("adresse") String adresse);


    @Modifying
    @Query("update Universite u set u.adresse=:adresse where u.idUniversite=:idUniversite")
    int updateUniversityByAdresse(@Param("adresse") String adresse , @Param("idUniversity") Long idUniversity);

    @Modifying
    @Query("DELETE FROM Universite u WHERE u.idUniversite =: idUniversite")
    int deleteByIdUniversite(@Param("idUniversity") Long idUniversity);*/
}
