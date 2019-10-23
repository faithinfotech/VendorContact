import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-vendor-add',
  templateUrl: './vendor-add.component.html',
  styleUrls: ['./vendor-add.component.scss']
})
export class VendorAddComponent implements OnInit {

  vendors: Vendor[];
  vendor = new Vendor();
  vId: number;
  cId: number;
  id: any;
  constructor(private service: VendorService, private router: Router) { }

  ngOnInit() {
    this.reset();
    this.getVendor();

  }

  getVendor(): void {
    this.service.getVendorById()
      .subscribe((response) => {
        this.vendor = response;
      }, (error) => {
        console.log(error);
      })

  }

  getContact(): void {
    this.service.getContactById()
      .subscribe((response) => {
        this.vendor = response;
      }, (error) => {
        console.log(error);
      })

  }

  getMaxId(): void {
    this.service.maxVid()
      .subscribe((response) => {
        this.id = response;
      }, (error) => {
        console.log(error);
      })
  }

  addVendor(): void {
    this.service.insertVendor(this.vendor)
      .subscribe((response) => {
        if(this.service.cId==0)
        {
          this.getMaxId();
        }
        else{
          this.service.vendor(this.vId);
        }
        
        this.router.navigate(['/contact']);

      }, (error) => {
        console.log(error);
      })
  }



  reset(): void {
    this.vendor.vId = 0;
    this.vendor.vName = null;
    this.vendor.address = null;
    this.vendor.location = "--select location--";
    this.vendor.pincode = null;
    this.vendor.service = "--select service--";
    this.vendor.cId = 0;
    this.vendor.cName = null;
    this.vendor.department = null;
    this.vendor.email = null;
    this.vendor.phone = null;
    this.vendor.isActive = "yes";
  }

  cancel() {
    this.router.navigateByUrl('/view');
  }
}
