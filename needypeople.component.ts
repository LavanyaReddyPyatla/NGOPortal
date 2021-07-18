import { Component, OnInit } from '@angular/core';

import { RequestService } from '../request.service';
import {Request} from '../request';
import { Logindto } from '../logindto';
import { LoginService } from '../loginService';


@Component({
  selector: 'app-needypeople',
  templateUrl: './needypeople.component.html',
  styleUrls: ['./needypeople.component.css']
})
export class NeedypeopleComponent implements OnInit {
  request:Request=new Request();
  msg:String;
  errorMsg:String;
  login : Logindto;

  constructor(private requestService:RequestService,public loginservice:LoginService ) { }

  ngOnInit(): void {
  }
  

  addRequestForHelp(){
   //this.login = this.loginservice.getLogin();
    //this.request.needyPeople.needyPersonId = this.login.userId;
    this.requestService.addRequestForHelp(this.request)
    .subscribe
    (
      (data: String | undefined)=>
      {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      },      
      (error: { error: String | undefined; })=>
      {
        this.errorMsg=error.error;
        console.log(error.error);
        this.msg=undefined
      }
     );
  }

}
