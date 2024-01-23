package com.example.premierprojettest.Respository;

import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
  /*  @Query("SELECT R FROM Reservation R WHERE R.estValide=:estValide")
    List<Bloc> ListReservationByEstValide(@Param("estValide") Boolean estValide);


    @Modifying
    @Query("update Reservation R set R.estValide=:estValide where R.idReservation=:idReservation")
    int updateReservationByEstValide(@Param("estValide") Boolean estValide , @Param("idFoyer") Long idReservation);

    @Modifying
    @Query("DELETE FROM Reservation R WHERE R.idReservation =: idReservation")
    int deleteByIdReservation(@Param("idReservation") Long idReservation);*/
}
