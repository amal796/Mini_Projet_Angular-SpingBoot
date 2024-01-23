package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.ReservationService;
import com.example.premierprojettest.model.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {
    @Autowired
    private final ReservationService ReservationService;

    @Operation(description = "récupérer toutes les Reservations de la base de données")
    @GetMapping("/retrieve-all-Reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = ReservationService.getReservation();
        return listReservations;
    }

    @PostMapping("/add-Reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        Reservation Reservation = ReservationService.addReservation(c);
        return Reservation;
    }

    @DeleteMapping("/remove-Reservation/{Reservation-id}")
    public void removeReservation(@PathVariable("Reservation-id") Long chId) {
        ReservationService.deleteReservation(chId);
    }

    @PutMapping("/modify-Reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        Reservation Reservation = ReservationService.updateReservation(c);
        return Reservation;
    }
}
