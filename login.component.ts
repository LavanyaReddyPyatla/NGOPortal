import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Logindto } from '../logindto';
import { LoginService } from '../loginService';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login:Logindto=new Logindto();
  
  constructor(public storageservice:StorageService, public loginservice:LoginService,
    public router:Router) { }

  ngOnInit() {
  }

  doLogin():void{
    this.login.password=this.loginservice.encryptString(this.login.password);
    console.log(this.login.password);
    this.loginservice.doLogin(this.login).subscribe(
      data=>{localStorage.setItem("userinfo",JSON.stringify(data));
      this.storageservice.loginflag=true;
      this.storageservice.username=JSON.parse(localStorage.getItem("userinfo") || '').userName;
      this.storageservice.msg=undefined || '';
      this.storageservice.role=JSON.parse(localStorage.getItem("userinfo")  || '').role;
      this.router.navigateByUrl("/home");},
      error=>{this.storageservice.msg="Incorrect Username and Password";
      this.storageservice.loginflag=false;
      this.router.navigateByUrl("/login");}
    );
  }

  logout(){
    this.loginservice.doLogout().subscribe();
    this.storageservice.loginflag=false;
    localStorage.removeItem("userinfo");
    this.router.navigateByUrl("/login");
  }

}
