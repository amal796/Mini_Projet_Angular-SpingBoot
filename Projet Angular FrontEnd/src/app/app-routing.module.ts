import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TableComponent } from './table/table.component';
import { AjoutComponent } from './ajout/ajout.component';
import { ModifComponent } from './modif/modif.component';
import { UniversiteRoutingModule } from './Universite/Components/Routing/Universite-routing.module';
import { EtudiantRoutingModule } from './etudiant/etudiant/etudiant-routing.module';
import { E404Component } from './e404/e404.component';
import { ChambreComponent } from "./chambre/chambre.component";
import { FoyerRoutingModule } from './foyer/foyer-routing.module';
import { BlocRoutingModule } from './bloc/bloc-routing.module';
import { ReservationRoutingModule } from './Reservation/Reservation/reservation/Reservation-routing.module';
import { LoginRoutingModule } from './login/login/login-routing.module';
const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'Table', component: TableComponent },
  { path: 'Ajouter', component: AjoutComponent },
  { path: 'chambres', component: ChambreComponent },
  { path: 'Modifier', component: ModifComponent },
  { path: 'login', loadChildren: () => import('./login/login/login.module').then(m => m.LoginModule) },
  { path: 'etudiants', loadChildren: () => import('./etudiant/etudiant/etudiant.module').then(m => m.EtudiantModule) },
  { path: 'universites', loadChildren: () => import('./Universite/Components/Routing/universite.module').then(m => m.UniversiteModule) },
  { path: 'foyers', loadChildren: () => import('./foyer/foyer.module').then(m => m.FoyerModule) },
  { path: 'Bloc', loadChildren: () => import('./bloc/bloc.module').then(m => m.BlocModule) },
  { path: 'resservations', loadChildren: () => import('./Reservation/Reservation/reservation/reservation.module').then(m => m.ReservationModule) },

  { path: '**', component: E404Component },

];

@NgModule({
  imports: [RouterModule.forRoot(routes),LoginRoutingModule, EtudiantRoutingModule, UniversiteRoutingModule, FoyerRoutingModule,BlocRoutingModule,ReservationRoutingModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
