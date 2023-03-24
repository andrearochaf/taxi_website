export class AddressBack {
    private _id: number;
    private _streetNumber: number;
    private _street: string;
    private _postcode: number;
    private _city: string;
    private _lattitude: number;
    private _longitude: number;
    private _addressType: string

    constructor(
    ) {}

    public set id(id: number){
        this._id = id;
    }

    public set streetNumber(streetNumber: number) {
        this._streetNumber = streetNumber;
    }
    public set street(street: string) {
        this._street = street;
    }
    public set postcode(postcode: number) {
        this._postcode = postcode;
    }
    public set city(city: string) {
        this._city = city;
    }
    public set lattitude(lattitude: number) {
        this._lattitude = lattitude;
    }
    public set longitude(longitude: number) {
        this._longitude = longitude;
    }
    public set addressType(addressType: string) {
        this._addressType = addressType;
    }
}