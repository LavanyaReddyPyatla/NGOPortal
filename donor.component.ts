import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from '../request';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css']
})
export class DonorComponent implements OnInit {

  requests!: Request[];
  msg: String | undefined = undefined;
  amount!: number;
  hidden: boolean = true;

  constructor(private requestService: RequestService,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {

    this.requestService.viewAll().subscribe(data => { this.requests = data }, error => console.log(error));

  }

  addAmount(request:Request) {
    console.log(request.amount);
    if (request.amount < 500 || request.amount > request.goal-request.raised) {
      request.msg = "amount must be minimum 500 and 10000";
      
      
    
    }
    else { request.msg = undefined ;
      request.raised=request.amount+request.raised;
      console.log(request);
    this.requestService.updateRequestRaised( request).subscribe((res: any) => { console.log(res) })
    alert("You have donated "+request.amount+" succesfully");
    
    }

  }

}




