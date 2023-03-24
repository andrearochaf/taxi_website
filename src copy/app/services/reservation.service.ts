import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AddressBack } from '@app/models/addressBack.model';
import { Reservation } from '@app/models/reservation.model';
import { environment } from '@environments/environment';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';

const API_URL = environment.apiUrl;
const headers = new HttpHeaders().set("Content-Type", "application/json");

@Injectable({
  providedIn: 'root'
})
export class ReservationService {


  constructor(private router: Router,
    private http: HttpClient) { }

    createAddress(address: AddressBack): Observable<any> {
      let body = JSON.stringify(address);
      return this.http.post(API_URL + '/address', body, { headers }).pipe(catchError(this.handleError));
    }

    createReservation(reservation: Reservation){
      let body = JSON.stringify(reservation);
      return this.http.post<Reservation>(API_URL + '/reservation', body, { headers }).pipe(catchError(this.handleError))
    }

    private  handleError(error: Response | any){
      //return observable.throw(error)
      return throwError(error);
    }
}
