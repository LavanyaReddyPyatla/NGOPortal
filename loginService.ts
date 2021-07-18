import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Logindto } from './logindto';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  login : Logindto;

  constructor(private http: HttpClient) { }
 
  encryptString(pwd:string):string{
    let str:string = "";
    for(let idx=0;idx<pwd.length;++idx)
    {
      str += String.fromCharCode(pwd.charCodeAt(idx)-3);
    }
    return str;
  }
  public doLogin(login:Logindto):Observable<any>{
    this.login = login;
    return this.http.post("http://localhost:7080/login",login);
  }

  public doLogout():Observable<any>{
    let token:string = JSON.parse(localStorage.getItem("userinfo") || '').token;
    console.log(token);
    const httpheaders=new HttpHeaders({"token-id":token});
    httpheaders.set("token-id",token);
    return this.http.get("http://localhost:7080/logout", {headers:httpheaders});
  }

  public getLogin():Logindto{
    return this.login;
  }
}