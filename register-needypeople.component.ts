import { Component, OnInit } from '@angular/core';
import { NeedyPeople } from '../needy-people';
import { NeedyPeopleService } from '../needy-people.service';

@Component({
  selector: 'app-register-needypeople',
  templateUrl: './register-needypeople.component.html',
  styleUrls: ['./register-needypeople.component.css']
})
export class RegisterNeedypeopleComponent implements OnInit {

  needypeople:NeedyPeople=new NeedyPeople();
  msg:String | undefined;
  errorMsg:String | undefined;


  constructor(private needypeopleservice:NeedyPeopleService) { }

  ngOnInit(): void {
  }

    addneedypeople(){
      this.needypeopleservice.addneedypeople(this.needypeople)
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


