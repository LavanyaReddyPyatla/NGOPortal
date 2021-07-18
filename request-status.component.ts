import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from '../request.service';
import {Request} from '../request';

@Component({
  selector: 'app-request-status',
  templateUrl: './request-status.component.html',
  styleUrls: ['./request-status.component.css']
})
export class RequestStatusComponent implements OnInit {
  requests!:Request[];
  id:any;

 
  msg:string | undefined;
  errorMsg:string  | undefined;
  searchText = '';


  constructor(private requestService:RequestService , private route:ActivatedRoute) { }

  ngOnInit(): void {

    console.log("Am inside view component");
    this.requestService.viewAll().subscribe((data:Request[])=>this.requests=data);
    console.log(this.requests);
  
  }
   
  updateStatus(request: Request) {
    
    console.log(request);
    this.requestService.updateRequest( request).subscribe((res: any) => { console.log(res) })
    
  }
  search()
  {
    if(this.id=='')
      {
        this.ngOnInit();
      }
      else
      {
        this.requests = this.requests.filter(res=>{
          return Number(res.id)==Number(this.id);
        })
      }
  }

}
