import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewComponent } from './view/view.component';
import { VendorAddComponent } from './vendor-add/vendor-add.component';
import { ContactAddComponent } from './contact-add/contact-add.component';
import { AuthguardGuard } from './authguard.guard';

     
const routes: Routes = [
  { path:'',component:LoginComponent},
  { path:'view',component:ViewComponent,canActivate:[AuthguardGuard]},
  { path:'crud',component:VendorAddComponent,canActivate:[AuthguardGuard]},
  { path:'contact',component:ContactAddComponent,canActivate:[AuthguardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
