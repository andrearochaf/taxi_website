import { Time } from "@angular/common";

export class Reservation {
    private _departureAddressId: number;
    private _arrivalAddressId :number;
    private _rideDate: string;
    private _rideTime: string;
    private _clientId: number

    constructor(){}

    public set departureAddressId(departureAddressId: number) {
        this._departureAddressId = departureAddressId;
    }

    public set arrivalAddressId(arrivalAddressId: number) {
        this._arrivalAddressId = arrivalAddressId;
    }

    public set rideDate(rideDate: string) {
        this._rideDate = rideDate;
    }
    public set rideTime(rideTime: string) {
        this._rideTime = rideTime;
    }
    public set clientId(clientId: number) {
        this._clientId = clientId;
    }
}