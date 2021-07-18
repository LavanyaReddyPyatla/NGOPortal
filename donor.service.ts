import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Donor } from './donor';

@Injectable({
  providedIn: 'root'
})
export class DonorService {

  constructor(private http:HttpClient) { }

  public addDonor(donor:Donor):Observable<any>{
    return this.http.post("http://localhost:7080/registerdonor",donor,{responseType:"text"});
  }  
}
