import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {Request} from './request';



@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private httpClient: HttpClient) { }

  public viewAll():Observable<any>{
    return this.httpClient.get("http://localhost:7080/requests");
  }

  public updateRequest(request: any):Observable<any>{
    return this.httpClient.put("http://localhost:7080/updatestatus/"+request.id
    ,request);
  }  

  public addRequestForHelp(request:Request):Observable<any>{
    console.log(request);
    return this.httpClient.post("http://localhost:7080/requestforhelp",request,{responseType:'text'});
  }

  public updateRequestRaised(request: any):Observable<any>{
    return this.httpClient.put("http://localhost:7080/addamount/"+request.id
    ,request);
  }  

}
