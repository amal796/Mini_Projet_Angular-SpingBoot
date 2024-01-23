package com.example.premierprojettest.Respository;

import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.Reservation;
import com.example.premierprojettest.model.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByType(TypeChambre type);

    List<Chambre> findByNumeroChambreAndType(Long numeroChambre, TypeChambre type);


}
