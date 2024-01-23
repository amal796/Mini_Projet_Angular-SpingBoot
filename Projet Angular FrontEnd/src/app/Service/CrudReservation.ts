import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../Models/Reservation';
import { Observable } from 'rxjs';
import { Etudiant } from '../Models/Etudiant';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
    providedIn: 'root'
})

export class CrudReservation {
    apiUrl = "http://localhost:8081/PremierProjetTest/Reservation";
    private baseURL = "http://localhost:8081/PremierProjetTest/api/v1/etudiants";
    constructor(private http: HttpClient) { }

    getReservations() {
        return this.http.get<Reservation[]>(this.apiUrl + "/retrieve-all-Reservations");
    }
    addReservation(Reservation: Reservation) {
        return this.http.post<any>(this.apiUrl + "/add-Reservation", Reservation, httpOptions);
    }
    getEtudiantsList(): Observable<Etudiant[]> {
        return this.http.get<Etudiant[]>(this.baseURL).pipe(
        );
      }

      deleteReservation(id: number) {
        const url = `${this.apiUrl + "/remove-Reservation"}/${id}`
        return this.http.delete(url, httpOptions)
    }
}