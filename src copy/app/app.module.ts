import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CourseComponent } from './course/course.component';
import { CourseApiService } from './services/course-api.service';
import { UserService } from './services/user.service';
import { MyspaceGuard } from './auth/myspace.guard';
import { MyspaceComponent } from './myspace/myspace.component';
import { AccountService } from './services/account.service';
import { CommonModule } from '@angular/common';
import { GeoApiGouvAddressModule } from "@placeme/ngx-geo-api-gouv-address";
import { GooglePlaceModule } from "ngx-google-places-autocomplete";
import { ReservationService } from './services/reservation.service';
import { FooterComponent } from './footer/footer.component';
import { TokenInterceptorService } from './token-interceptor.service';
import { GoogleMapsModule } from '@angular/google-maps';
import { AccordionModule } from '@syncfusion/ej2-angular-navigations';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CourseComponent,
    MyspaceComponent,
    FooterComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    GeoApiGouvAddressModule.forRoot(),
    GooglePlaceModule, 
    GoogleMapsModule,
    AccordionModule ,
  ],
  providers: [CourseApiService,AccountService, UserService,ReservationService, MyspaceGuard,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
