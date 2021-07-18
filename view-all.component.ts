import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';

import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllEmployeeComponent implements OnInit {
  employees:Employee[]=[];
  msg:string | undefined;
  errorMsg:string | undefined;

  constructor(private employeeService:EmployeeService){ }
  data:string | undefined;
  ngOnInit(): void {
    console.log('inside view component');
    this.employeeService.viewAll().subscribe(data=>this.employees=data);
    console.log(this.employees);
  }
  
  deleteEmployee(employeeId:number){

    if(confirm("Confirm Deletion of Employee:"+employeeId)){
      this.employeeService.delEmployee(employeeId)
      .subscribe(data=>{
        this.msg=data;
        this.errorMsg=undefined;
        this.employeeService.viewAll().subscribe(data=>this.employees=data);
        console.log(this.employees);
      },
      error=>{
        this.errorMsg=error.error;
          this.msg=undefined;
        
      });
    }
  }

  updateEmployeeStatus(employee: Employee) {
    
    console.log(employee);
    this.employeeService.updateEmployeeStatus( employee).subscribe((res: any) => { console.log(res) })
    
  }

}
