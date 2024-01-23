package com.example.premierprojettest.Respository;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    public List<Etudiant> findByCin(Long cin);
    /*@Query("SELECT E FROM Etudiant E WHERE E.cin=:cin")
    List<Bloc> ListEtudiantByCin(@Param("cin") String cin);


    @Modifying
    @Query("update Etudiant E set E.cin=:cin where E.idEtudiant=:idEtudiant")
    int updateEtudiantByCin(@Param("cin") String cin , @Param("idEtudiant") Long idEtudiant);

    @Modifying
    @Query("DELETE FROM Etudiant E WHERE E.idEtudiant =: idEtudiant")
    int deleteByIdEtudiant(@Param("idEtudiant") Long idEtudiant);*/
}
