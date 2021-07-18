import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import {Validators} from "@angular/forms";
import {Router} from "@angular/router";
@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  [x: string]: any;
  employee :Employee=new Employee();
  msg!: string;
  errorMsg!: string;

  constructor(private employeeService:EmployeeService) { }

  ngOnInit(): void {
  }

  addEmployee(){
    console.log('inside view component');
    this.employeeService.addEmployee(this.employee)
    .subscribe(
      (data)=>
      {
      this.msg=data;
      this.errorMsg = undefined || '';
    },
    (error)=>
    {
      this.errorMsg=error.error;
      console.log(error.error);
      this.msg=undefined||'';
    }    
    );
    this.router.navigateByUrl('addemployee')
    
  }


}
