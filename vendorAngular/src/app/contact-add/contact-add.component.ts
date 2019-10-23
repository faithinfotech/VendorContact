import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-contact-add',
  templateUrl: './contact-add.component.html',
  styleUrls: ['./contact-add.component.scss']
})
export class ContactAddComponent implements OnInit {
  vendor = new Vendor();
  vendors: Vendor[];
  vId: number;
  id: any;

  constructor(private service: VendorService, private router: Router) { }

  ngOnInit() {

    this.getMaxId();
    this.getVendor();
    this.getContact();

  }

  getMaxId(): void {
    this.service.maxVid()
      .subscribe((response) => {
        this.id = response;
        this.vendor.vId = this.id;
      }, (error) => {
        console.log(error);
      })
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


  addContact(): void {

    //this.vendor.vId = this.id;
    this.service.insertContact(this.vendor)
      .subscribe((response) => {
        this.router.navigateByUrl('/view');
      }, (error) => {
        console.log(error);
      })
  }

  viewContact(): void {
    this.service.getAllContact()
      .subscribe((data) => {
        this.vendors = data;
      },
        (error) => {
          console.log(error);
        })
  }

  cancel(): void {
    this.router.navigateByUrl('/view');
  }
}
