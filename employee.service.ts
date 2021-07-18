import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  public viewAll():Observable<any>{
    console.log('inside service');
    return this.http.get("http://localhost:7080/find_all_employees");
    }

  public addEmployee(employee:Employee):Observable<any>{
    return this.http.post("http://localhost:7080/add_employee",employee,{responseType:"text"});
  }  

  delEmployee(empId: number) :Observable<any>{
    console.log("http://localhost:7081/remove_employee_by_id"+empId);
    return this.http.delete("http://localhost:7080/remove_employee_by_id/"+empId,{responseType:'text'});
  }

  public updateEmployeeStatus(employee: any):Observable<any>{
    return this.http.put("http://localhost:7080/update_employee_status/"+employee.employeeId
    ,employee);
  }  
    
  }


