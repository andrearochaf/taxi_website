import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FetchService {

  constructor(private _http:HttpClient) { }

  getaddress(query:string){
    return this._http.get("https://api-adresse.data.gouv.fr/search/?q="+query+"&autocomplete=1");
  }
}
