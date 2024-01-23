import { Component, OnInit } from '@angular/core';
import { Etudiant } from 'src/app/Models/Etudiant';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CrudReservation } from 'src/app/Service/CrudReservation';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {
  BlocForm: FormGroup;
  etudiants: Etudiant[];
  formSubmitted = false;

  constructor(
    private services: CrudReservation,
    private router: Router,
    private fb: FormBuilder
  ) {
    let formControls = {
      anneeUniversitaire: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
      ]),
      estValide: new FormControl('', [
        Validators.required,
      ]),
      etudiant: new FormControl('', [
        Validators.required,
      ]),
    };
    this.BlocForm = this.fb.group(formControls);
  }

  ngOnInit(): void {
    this.services.getEtudiantsList().subscribe(
      (etudiants) => {
        this.etudiants = etudiants;
        console.log(etudiants); 
      },
      (error) => {
        console.error(error);
      }
    );
  }

  get anneeUniversitaire() { return this.BlocForm.get('anneeUniversitaire'); }
  get estValide() { return this.BlocForm.get('estValide'); }
  get etudiant() { return this.BlocForm.get('etudiant'); }


  validateField(field: string) {
    return (
      this.BlocForm.get(field)?.invalid &&
      (this.BlocForm.get(field)?.touched || this.formSubmitted)
    );
  }

  getErrorMessage(field: string) {
    if (this.BlocForm.get(field)?.hasError('required')) {
      return 'Ce champ est obligatoire';
    }
    if (this.BlocForm.get(field)?.hasError('minlength')) {
      return 'Ce champ doit contenir au moins 4 caractères';
    }
    // Ajoutez d'autres messages d'erreur personnalisés si nécessaire
    return '';
  }

  addNewReservation() {
    this.formSubmitted = true;

    if (this.BlocForm.invalid) {
      return;
    }

    let data = this.BlocForm.value;
    console.log(data);
    
    let selectedEtudiant = this.etudiants.find(etudiant => etudiant.idEtudiant == data.etudiant);
    
    if (selectedEtudiant) {
      let reservation = {
        anneeUniversitaire: data.anneeUniversitaire,
        estValide: data.estValide,
        etudiants: [selectedEtudiant]
      };
    
      console.log(reservation);
    
      this.services.addReservation(reservation).subscribe(
        res => {
          console.log(res);
          this.router.navigate(['/listeReservation']);
        },
        err => {
          console.log(err);
        }
      );
    }
  }

}