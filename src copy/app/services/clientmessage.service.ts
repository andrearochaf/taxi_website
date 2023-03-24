import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Clientmessage } from '@app/models/clientmessage.model';
import { Person } from '@app/models/person.model';
import { TokenInterceptorService } from '@app/token-interceptor.service';
import { environment } from '@environments/environment';
import { catchError, Observable, throwError } from 'rxjs';


const API_URL = environment.apiUrl;
const headers = new HttpHeaders().set("Content-Type", "application/json");

@Injectable({providedIn: 'root'})
export class ClientmessageService {

  constructor(private router: Router,
    private http: HttpClient) { }

    createMessage(message: Clientmessage): Observable<any> {
      let body = JSON.stringify(message);
      return this.http.post(API_URL + '/message', body, { headers }).pipe(catchError(this.handleError));
    }

    getAll() {  
      return this.http.get<Clientmessage[]>(environment.apiUrl + "/messages");
  }
  
  private  handleError(error: Response | any){
    //return observable.throw(error)
    return throwError(error);
  }
}
