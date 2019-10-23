import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Vendor } from './vendor';

@Injectable({
  providedIn: 'root'
})
export class VendorService {
  vId: number;
  cId: number;
  department: string;
  vendorss = new Vendor();

  constructor(private httpService: HttpClient) { }

  getAll(): Observable<Vendor[]> {
    return this.httpService.get<Vendor[]>(environment.APIUrl + 'vendor');
  }

  getAllContact(): Observable<Vendor[]> {
    return this.httpService.get<Vendor[]>(environment.APIUrl + 'contact');
  }

  getVendorById(): Observable<Vendor> {
    return this.httpService.get<Vendor>(environment.APIUrl + 'vendor/' + this.vId);
  }

  getContactById(): Observable<Vendor> {
    return this.httpService.get<Vendor>(environment.APIUrl + 'contact/' + this.cId);
  }


  insertVendor(vendor: any) {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    if (vendor.vId != 0) {
      return this.httpService.put(environment.APIUrl + 'vendor', body, options);
    }
    else {
      return this.httpService.post(environment.APIUrl + 'vendor', body, options);
    }
  }


  insertContact(vendor: any) {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    if (this.cId != 0) {
      return this.httpService.put(environment.APIUrl + 'contact', body, options);
    }
    else {
      return this.httpService.post(environment.APIUrl + 'contact', body, options);
    }
  }

  editVendor(vId: number, cId: number) {
    this.vId = vId;
    this.cId = cId;
  }
  vendor(vId: number) {
    this.vId = vId;
  }


  contactDelete(cId: number) {

    return this.httpService.delete(environment.APIUrl + 'contact/' + cId);

  }

  search(department: string): Observable<Vendor[]> {
    return this.httpService.get<Vendor[]>(environment.APIUrl + 'contact/search/' + department);
  }

  public maxVid() {
    return this.httpService.get(environment.APIUrl + 'vendor/max/vId');
  }
}
