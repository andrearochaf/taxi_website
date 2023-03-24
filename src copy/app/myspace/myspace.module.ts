import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyspaceRoutingModule } from './myspace-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { EditadressComponent } from './editadress/editadress.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ClientmessageService } from '@app/services/clientmessage.service';
import { TokenInterceptorService } from '@app/token-interceptor.service';
import { ClientspaceComponent } from './clientspace/clientspace.component';
import { AdminspaceComponent } from './adminspace/adminspace.component';



@NgModule({
  declarations: [
    EditadressComponent,
    ClientspaceComponent,
    AdminspaceComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MyspaceRoutingModule,
    HttpClientModule,
  ],
  providers: [ClientmessageService, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
})
export class MyspaceModule { }
