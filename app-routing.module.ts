import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/addemployee.component';
import { AdminComponent } from './admin/admin.component';
import { DonorComponent } from './donor/donor.component';
import {HomeComponent} from './home/home.component'
import { LoginComponent } from './login/login.component';
import { NeedypeopleComponent } from './needypeople/needypeople.component';
import { RegisterDonorComponent } from './register-donor/register-donor.component';
import { RegisterNeedypeopleComponent } from './register-needypeople/register-needypeople.component';
import { RequestStatusComponent } from './request-status/request-status.component';
import { ViewAllEmployeeComponent } from './view-all-employee/view-all.component';
import { ViewNeedypeopleComponent } from './view-needypeople/view-needypeople.component';

const routes: Routes = [
                          {'path':'home',component:HomeComponent},
                          {'path':'login',component:LoginComponent},
                          {'path':'donor',component:DonorComponent},
                          {'path':'needypeople',component:NeedypeopleComponent},
                          {'path':'add-employee',component:AddEmployeeComponent},
                          {'path':'view-all-employee',component:ViewAllEmployeeComponent},
                          {'path':'admin',component:AdminComponent},
                          {'path':'request-status',component:RequestStatusComponent},
                          {'path':'view-needypeople',component:ViewNeedypeopleComponent},
                          {'path':'register-needypeople',component:RegisterNeedypeopleComponent},
                          {'path':'register-donor',component:RegisterDonorComponent}
                          
                        ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
