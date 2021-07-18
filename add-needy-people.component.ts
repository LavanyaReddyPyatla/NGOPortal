import { Component, OnInit } from '@angular/core';
import { NeedyPeople } from '../needy-people';
import { NeedyPeopleService } from '../needy-people.service';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-needy-people',
  templateUrl: './add-needy-people.component.html',
  styleUrls: ['./add-needy-people.component.css']
})
export class AddNeedyPeopleComponent implements OnInit {

  needypeople:NeedyPeople=new NeedyPeople();
  msg:String | undefined;
  errorMsg:String | undefined;

  
  constructor(private needypeopleservice:NeedyPeopleService){}

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

