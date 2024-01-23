import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/Models/Reservation';
import { CrudReservation } from 'src/app/Service/CrudReservation';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-reservation',
  templateUrl: './list-reservation.component.html',
  styleUrls: ['./list-reservation.component.css']
})
export class ListReservationComponent implements OnInit {
  reservations: Reservation[] = [];

  constructor(private service: CrudReservation, private router: Router) {}

  ngOnInit(): void {
    this.loadReservations();
  }

  loadReservations(): void {
    this.service.getReservations().subscribe(
      data => {
        this.reservations = data;
        console.log('reservations:', data);
      },
      error => {
        console.error('Erreur lors de la récupération des réservations', error);
      }
    );
  }

  onDeleteBloc(reservation: Reservation) {
    if (confirm("Voulez vous supprimer ce reservation ?")) {

      this.service.deleteReservation(reservation.idReservation).subscribe(() => {
        this.router.navigate(['/listeReservation']).then(() => {
          window.location.reload()
        })
      })
    }
  }
}