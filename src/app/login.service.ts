import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  formData:Login;

  constructor(private _httpService : HttpClient) { }

  login(formData:any):Observable<Login>{ 
    return this._httpService.get<Login>(environment.APIUrl +'login/'+ formData.userName+'/'+formData.password);   
  }
}