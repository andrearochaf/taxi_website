export class Clientmessage {

    private _name: string;
    private _message: string;
    private _receivedDate: string;
    private _transmitterEmail: string;
    private _replyDate: Date

    constructor() { }

    public set name(name: string) {
        this._name = name;
    }
    public set message(message: string) {
        this._message = message;
    }
    public set transmitterEmail(transmitterEmail: string) {
        this._transmitterEmail = transmitterEmail;
    }
    public set receivedDate(receivedDate: string) {
        this._receivedDate = receivedDate;
    }
    public set replyDate(replyDate: Date) {
        this._replyDate = replyDate;
    }

}