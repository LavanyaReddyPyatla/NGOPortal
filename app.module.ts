import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DonorComponent } from './donor/donor.component';
import { NeedypeopleComponent } from './needypeople/needypeople.component';

import { AdminComponent } from './admin/admin.component';
import { AddEmployeeComponent } from './add-employee/addemployee.component';
import { ViewAllEmployeeComponent } from './view-all-employee/view-all.component';
import { RequestStatusComponent } from './request-status/request-status.component';
import { ViewNeedypeopleComponent } from './view-needypeople/view-needypeople.component';
import { RegisterNeedypeopleComponent } from './register-needypeople/register-needypeople.component';
import { RegisterDonorComponent } from './register-donor/register-donor.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    DonorComponent,
    NeedypeopleComponent,
    
    AdminComponent,
    AddEmployeeComponent,
    ViewAllEmployeeComponent,
    RequestStatusComponent,
    ViewNeedypeopleComponent,
    RegisterNeedypeopleComponent,
    RegisterDonorComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
