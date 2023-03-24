import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ReservationService } from '@app/services/reservation.service';
import { Address } from 'ngx-google-places-autocomplete/objects/address';
import { AddressBack } from '@app/models/addressBack.model';
import { Reservation } from '@app/models/reservation.model';
import { UserService } from '@app/services/user.service';
import { } from '@google/maps';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  formulaire!: FormGroup;
  isValid = false;
  googleOriginAddress: Address;
  googleDestinationAddress: Address;
  departureAddress = new AddressBack();
  arrivalAddress = new AddressBack();
  reservation: Reservation = new Reservation();
  result:number;
  estimation : string;

  constructor(

    //private geoApiGouvAddressServiceOriginAdress: GeoApiGouvAddressService,
    // private geoApiGouvAddressServiceArrivalAdress: GeoApiGouvAddressService,
    private reservationService: ReservationService,
    public userService: UserService,
  ) { }

  ngOnInit() {
   
  }

  handleAddressChangeDepart(address: Address): Address {

    //si le client tape un numero de rue, alors ce format d'adresse nous ai fournit par google
    if (!isNaN(parseInt(address.address_components[0].long_name))) {
      this.isValid = true;
      this.departureAddress.streetNumber = parseInt(address.address_components[0].long_name);
      this.departureAddress.street = address.address_components[1].long_name;
      this.departureAddress.city = address.address_components[2].long_name;
      this.departureAddress.postcode = parseInt(address.address_components[6].long_name);
      this.departureAddress.lattitude = address.geometry.location.lat();
      this.departureAddress.longitude = address.geometry.location.lng();
      this.departureAddress.addressType = "DEPART";
      //dans le cas ou le client ne met pas de numero de rue:
    } else {
      this.departureAddress.street = address.address_components[0].long_name;
      this.departureAddress.city = address.address_components[1].long_name;
      this.departureAddress.lattitude = address.geometry.location.lat();
      this.departureAddress.longitude = address.geometry.location.lng();
      this.departureAddress.addressType = "DEPART";
      if ((address.address_components[5]) && (!isNaN(parseInt(address.address_components[5].long_name)))) {
        this.departureAddress.postcode = parseInt(address.address_components[5].long_name);
      }
    }
    return this.googleOriginAddress = address;
  }

  handleAddressChangeArrivee(address: Address): Address {
    if (!isNaN(parseInt(address.address_components[0].long_name))) {
      this.isValid = true;
      this.arrivalAddress.streetNumber = parseInt(address.address_components[0].long_name);
      this.arrivalAddress.street = address.address_components[1].long_name;
      this.arrivalAddress.city = address.address_components[2].long_name;
      this.arrivalAddress.postcode = parseInt(address.address_components[6].long_name);
      this.arrivalAddress.lattitude = address.geometry.location.lat();
      this.arrivalAddress.longitude = address.geometry.location.lng();
      this.arrivalAddress.addressType = "ARRIVEE";
    } else {
      this.arrivalAddress.street = address.address_components[0].long_name;
      this.arrivalAddress.city = address.address_components[1].long_name;
      this.arrivalAddress.lattitude = address.geometry.location.lat();
      this.arrivalAddress.longitude = address.geometry.location.lng();
      this.arrivalAddress.addressType = "ARRIVEE";
      if ((address.address_components[5]) && (!isNaN(parseInt(address.address_components[5].long_name)))) {
        this.arrivalAddress.postcode = parseInt(address.address_components[5].long_name);
      }
    }
    return this.googleDestinationAddress = address;
  }

  /*
  Pour utiliser l'api address du gouvernement

  change(event: any) {
    this.possibleAddresses=[];
    origin = event.target.value
    fetch("https://api-adresse.data.gouv.fr/search/?q=" + origin + "&autocomplete=1")
    .then(r => r.json())
    .then(j => { (j.features.forEach((value: object) => {
      this.possibleAddresses.push(JSON.parse(JSON.stringify(value)).properties.label);
    })); });
  };
  //console.log(event.target.value);
*/
   
    estimate():void { 
     
      const gmd = new google.maps.DistanceMatrixService()
      gmd.getDistanceMatrix ({ 
        origins: [this.googleOriginAddress.formatted_address], 
        destinations: [this.googleDestinationAddress.formatted_address],
        avoidHighways: true,
        avoidTolls: false,
        travelMode: google.maps.TravelMode.DRIVING }) 
        .then( (resp: any) => {
        this.result= parseInt(resp.rows[0].elements[0].distance.text.split(" ", 1)[0]);  
          this.estimation = "durée du trajet: " + resp.rows[0].elements[0].duration.text + "\r\ncout: " + (1.47*this.result+7) +"€"
      } )
        
       }

  book() {

    if (this.isValid) {
      console.log(this.departureAddress)
      this.reservationService.createAddress(this.arrivalAddress);
      this.reservationService.createAddress(this.departureAddress);

      this.reservation.departureAddressId = this.departureAddress.id;
      this.reservation.arrivalAddressId = this.arrivalAddress.id;
      this.reservation.rideDate = this.formulaire.controls.date.value
      this.reservation.rideTime = this.formulaire.controls.time.value


      this.reservationService.createReservation(this.reservation).subscribe(data => { return true; })

      alert('reservation sauvegardée !! :-)\n\n');
    }
  }

}


