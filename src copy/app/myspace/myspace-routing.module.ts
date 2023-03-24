import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '@app/auth/auth.guard';
import { AdminspaceComponent } from './adminspace/adminspace.component';
import { ClientspaceComponent } from './clientspace/clientspace.component';
import { EditadressComponent } from './editadress/editadress.component';
import { MyspaceComponent } from './myspace.component';

const routes: Routes = [
  
        { path: 'editAdress', component: EditadressComponent },
        { path: 'admin', component: AdminspaceComponent },
        { path: 'client', component: ClientspaceComponent },
        

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MyspaceRoutingModule { }
