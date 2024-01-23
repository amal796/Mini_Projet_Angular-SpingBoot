import { Etudiant } from "./Etudiant";

export class Reservation {
    constructor(
        public idReservation?: number,
        public anneeUniversitaire?: Date,
        public estValide?: boolean,
        public etudiants?: Etudiant[]
    ) {


    }
  }