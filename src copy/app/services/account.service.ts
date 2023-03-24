import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { environment } from '@environments/environment';
import { Person } from '../models/person.model';


//url for api
const API_URL = environment.apiUrl;
const headers = new HttpHeaders().set("Content-Type", "application/json");

@Injectable({ providedIn: 'root' })
export class AccountService {
    private personSubject: BehaviorSubject<Person | null>;
    public person: Observable<Person | null>;

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.personSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('person')!));
        this.person = this.personSubject.asObservable();
    }

    public get personValue() {
        return this.personSubject.value;
    }

    login(username: string, password: string) {
        return this.http.post<Person>(API_URL + '/authorize', { username, password })
            .pipe(map(person => {
                // store Person details and jwt token in local storage to keep Person logged in between page refreshes
                localStorage.setItem('token', person.token);
                this.personSubject.next(person);
                return person;
            }));
    }
    getToken(){
        return localStorage.getItem('token')
      }

    logout() {
        // remove Person from local storage and set current Person to null
        localStorage.removeItem('Person');
        this.personSubject.next(null);
        this.router.navigate(['/account/login']);
    }

    createPerson(person: Person): Observable<any> {
        let body = JSON.stringify(person);
        console.log("je suis dans la creation de personne " +body)
        return this.http.post(API_URL + '/register', body, { headers }).pipe(catchError(this.handleError));
      }

    register(person: Person) {
        return this.http.post<any>(environment.apiUrl + "/register", person);
    }

    getByUsername(username: string) {
        return this.http.get<Person>(`${environment.apiUrl}/persons/${username}`);
    }

    private  handleError(error: Response | any){
        //return observable.throw(error)
        return throwError(error);
      }
}