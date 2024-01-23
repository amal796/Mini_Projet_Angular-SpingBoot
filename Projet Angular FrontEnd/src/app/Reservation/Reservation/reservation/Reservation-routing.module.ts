import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddReservationComponent } from '../../AddReservation/add-reservation/add-reservation.component';
import { ListReservationComponent } from '../../ListReservation/list-reservation/list-reservation.component';
import { LayoutComponentComponent } from 'src/app/layout-component/layout-component.component';
const routes: Routes = [
    {
      path: 'listeReservation',
      component: LayoutComponentComponent,
      children: [
        { path: '', component: ListReservationComponent },
        { path: 'createReservation', component: AddReservationComponent },
      ],
    },
    { path: '', redirectTo: '/listeReservation', pathMatch: 'full' },
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
  })
  export class ReservationRoutingModule {}
