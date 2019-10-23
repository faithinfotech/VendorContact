import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxPaginationModule} from 'ngx-pagination';
import{ConfirmationPopoverModule} from 'angular-confirmation-popover';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { from } from 'rxjs';
import { ViewComponent } from './view/view.component';
import { VendorAddComponent } from './vendor-add/vendor-add.component';
import { ContactAddComponent } from './contact-add/contact-add.component';
import { AuthguardGuard } from './authguard.guard';
import { LoginService } from './login.service';
import { VendorService } from './vendor.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewComponent,
    VendorAddComponent,
    ContactAddComponent
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger' // set defaults here
    }),
    AppRoutingModule
  ],
  providers: [AuthguardGuard,LoginService,VendorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
