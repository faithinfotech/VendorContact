import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  public popoverTitle: string = 'Delete';
  public popoverMessage: string = 'Do you want to delete ?';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;

  vendor: Vendor[];
  vendors = new Vendor();
  result: string;

  constructor(private router: Router, private service: VendorService) { }

  ngOnInit() {
    // this.viewVendor();
    this.viewContact();
    // this.getCondition();
  }

  viewContact(): void {
    this.service.getAllContact()
      .subscribe((data) => {
        this.vendor = data,
          console.log(data);
      },
        (error) => {
          console.log(error);
        })
  }


  delete(cId: number) {
    this.service.contactDelete(cId)
      .subscribe((response) => {
        this.viewContact();
      }, (error) => {
        console.log(error);
      })
  }
  searchVendor(department: string) {
    this.result = "";
    if (department != "") {
      this.service.search(department)
        .subscribe((response) => {
          this.vendor = response;
          if (this.vendor.length == 0) {
            this.result = "No result";
          }

        }, (error) => {
          console.log(error);
        })
    }
    else {
      this.viewContact();
    }
  }


  addVendor(): void {
    this.service.vId = 0;
    this.service.cId = 0;
    this.router.navigateByUrl('/crud');
  }

  editVendor(vId: number, cId: number) {

    this.service.editVendor(vId, cId);
    this.router.navigate(['/crud']);
  }

  logout(): void {
    localStorage.removeItem('token');
    this.router.navigate(['']);
  }
}
