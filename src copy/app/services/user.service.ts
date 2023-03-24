import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private isUserLoggedIn : boolean;
  private username : string;

  constructor() { 
    this.isUserLoggedIn = false;
  }

  setUserLoggedIn(){
    this.isUserLoggedIn = true;
  }

  setUserLoggedOff(){
    this.isUserLoggedIn = false;
  }

  getUserLoggedIn(){
    return this.isUserLoggedIn;
  }

  setUsername(username: string){
    this.username = username;
  }
  getUsername(){
    return this.username;
  }

  getToken(){
    return localStorage.getItem('token')
  }
}

