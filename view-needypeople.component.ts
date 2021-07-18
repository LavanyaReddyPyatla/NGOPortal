import { Component, OnInit } from '@angular/core';
import { NeedyPeople } from '../needy-people';
import { NeedyPeopleService } from '../needy-people.service';

@Component({
  selector: 'app-view-needypeople',
  templateUrl: './view-needypeople.component.html',
  styleUrls: ['./view-needypeople.component.css']
})
export class ViewNeedypeopleComponent implements OnInit {


  needypeoples:NeedyPeople[]=[];
  email :any;
  modify= new NeedyPeople();
  updateDiv:boolean=false;
  msg:string|undefined;
  errorMsg:string|undefined;
  
  searchText = '';

  constructor(private needypeopleService:NeedyPeopleService) { }

  ngOnInit(): void {
    console.log("Am inside view component");
    this.needypeopleService.view().subscribe((data: NeedyPeople[])=>this.needypeoples=data);
    console.log(this.needypeoples);
  }

  Search()
  {
    if(this.email=="")
      {
        this.ngOnInit();
      }
      else
      {
        this.needypeoples = this.needypeoples.filter(res=>{
          return res.email.toLocaleLowerCase().match(this.email.toLocaleLowerCase());
        })
      }
  }

  update(newneedypeople:NeedyPeople)
  {
    console.log(JSON.stringify(newneedypeople));
    this.modify=newneedypeople;
    this.updateDiv=true;//make update division visible
  }
  cancel()
  {
    this.updateDiv=false;//make update division invisible
  }

  updateNeedy(){
    this.updateDiv=false;//make update division invisible
    this.needypeopleService.updateNeedy(this.modify)
          .subscribe(data=>{
            this.msg=data;
            this.errorMsg=undefined;
            //Reload account
            this.needypeopleService.view().subscribe(data=>this.needypeoples=data);
            console.log(this.needypeoples);
          },
            error=>{
              this.errorMsg=error.error;
              this.msg=undefined;
            });

  }
}


