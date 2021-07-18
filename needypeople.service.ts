import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NeedypeopleService {

  constructor(private httpClient:HttpClient) {
    
   }
   public addRequestForHelp(request: any):Observable<any>{
    return this.httpClient.post("http://localhost:7080/requestforhelp",request,{responseType:'text'});
  }
}
