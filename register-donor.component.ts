import { Component, OnInit } from '@angular/core';
import { Donor } from '../donor';
import { DonorService } from '../donor.service';

@Component({
  selector: 'app-register-donor',
  templateUrl: './register-donor.component.html',
  styleUrls: ['./register-donor.component.css']
})
export class RegisterDonorComponent implements OnInit {

  [x: string]: any;
  donor :Donor=new Donor();
  msg!: string;
  errorMsg!: string;

  constructor(private donorService:DonorService) { }

  ngOnInit(): void {


  }

  addDonor(){
    console.log('inside view component');
    this.donorService.addDonor(this.donor)
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
    this.router.navigateByUrl('registerdonor')
    
  }


}



