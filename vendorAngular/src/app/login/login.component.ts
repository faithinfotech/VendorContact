import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user = new Login();
  constructor(private service: LoginService, private router: Router) { }

  ngOnInit() {
    this.resetForm();
  }

  myLogin() {
    this.service.login(this.user)
      .subscribe((response) => {
        localStorage.setItem('token','123456789');
        this.router.navigate(['/view']);      
        this.resetForm();
      }, (error) => {
        this.resetForm();
        console.log(error);
      });
  }

  resetForm(form?: NgForm) {
    if (!form) {
      this.user.userName = '';
      this.user.password = '';
      this.service.formData = {
        userId: 0,
        userName: null,
        password: null

      }
    }
  }
}
