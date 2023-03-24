import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '@app/auth/auth.guard';
import { HomeComponent } from '@app/home/home.component';
import { MyspaceComponent } from '@app/myspace/myspace.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
    
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    {path: '', component: HomeComponent},
    {path: 'myspace', component: MyspaceComponent,canActivate: [AuthGuard]}  

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
