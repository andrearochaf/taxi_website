import { Role } from "./role.model";

export class Person {
    constructor(
    public id: number,
    public firstName: string,
    public name: string,
    public phone: string,
    public username: string,
    public email:string,
    public password: string,
    public token: string,
    public authorities: { id: number; name: string; authority: string }[],   
    ){}
}