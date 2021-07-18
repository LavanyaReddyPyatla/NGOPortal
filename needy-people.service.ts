import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NeedyPeople } from './needy-people';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class NeedyPeopleService {
  [x: string]: any;

  constructor(private http:HttpClient) { }

  public addneedypeople(needypeople:NeedyPeople):Observable<any>{
    console.log(needypeople);
    return this.http.post("http://localhost:7080/addneedypeople",needypeople,{responseType:'text'});
  }

  public view():Observable<any>{
    return this.http.get("http://localhost:7080/find_all_needy");

  }

  updateNeedy(modify:NeedyPeople)
  {
    return this.http.put("http://localhost:7080/update_needypeople",modify,{responseType:'text'});
  }

 

  
}
