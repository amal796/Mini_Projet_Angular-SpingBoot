package com.example.premierprojettest.Service;

import com.example.premierprojettest.model.Chambre;
import com.example.premierprojettest.model.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> getReservation();
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(Long id);
}
