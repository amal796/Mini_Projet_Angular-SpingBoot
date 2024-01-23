package com.example.premierprojettest.Service;

import com.example.premierprojettest.Respository.ReservationRepository;
import com.example.premierprojettest.model.Etudiant;
import com.example.premierprojettest.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReservationService")

public class ReservationService implements IReservationService{
    private final ReservationRepository ReservationRepository  ;

    @Autowired
    public ReservationService(com.example.premierprojettest.Respository.ReservationRepository reservationRepository) {
        ReservationRepository = reservationRepository;
    }


    @Override
    public List<Reservation> getReservation() {
        return (List<Reservation>) ReservationRepository.findAll();

    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return ReservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Long id=reservation.getIdReservation();
        Reservation reservation1=ReservationRepository.findById(Long.valueOf(id)).get();
        reservation1.setAnneeUniversitaire(reservation.getAnneeUniversitaire());
        reservation1.setEstValide(reservation.getEstValide());
        return ReservationRepository.save(reservation1);
    }

    @Override
    public void deleteReservation(Long id) {
        ReservationRepository.deleteById(id);

    }
}
