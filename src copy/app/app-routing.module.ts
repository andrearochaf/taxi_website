import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CourseComponent } from './course/course.component';
import { AuthGuard } from './auth/auth.guard';



const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'course',component: CourseComponent},
  {path:'account', loadChildren: () => import('./account/account.module').then(mod=>mod.AccountModule)},
  {path:'myspace', loadChildren: () => import('./myspace/myspace.module').then(mod=>mod.MyspaceModule), canActivate: [AuthGuard]},
  
  {path:'info', loadChildren: () => import('./info/info.module').then(mod=>mod.InfoModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
