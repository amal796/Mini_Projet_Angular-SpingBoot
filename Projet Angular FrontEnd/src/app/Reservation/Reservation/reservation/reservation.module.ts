import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddReservationComponent } from '../../AddReservation/add-reservation/add-reservation.component';
import { ListReservationComponent } from '../../ListReservation/list-reservation/list-reservation.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppModule } from 'src/app/app.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ReservationRoutingModule } from './Reservation-routing.module';
@NgModule({
  declarations: [
    AddReservationComponent,
    ListReservationComponent,
  ],
  imports: [
    AppModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ReservationRoutingModule,
  ]
})
export class ReservationModule { }
