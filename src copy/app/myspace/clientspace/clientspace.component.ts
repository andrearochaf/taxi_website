import { Component, OnInit } from '@angular/core';
import { Person } from '@app/models/person.model';
import { AccountService } from '@app/services/account.service';
import { UserService } from '@app/services/user.service';


@Component({
  selector: 'app-clientspace',
  templateUrl: './clientspace.component.html',
  styleUrls: ['./clientspace.component.css']
})
export class ClientspaceComponent implements OnInit {
  person: any;
 
  constructor(public userService: UserService, private accountService: AccountService) { }

  ngOnInit(): void {
   this.person = this.accountService.personValue 
    } 

getInfo(){
  console.log(this.person.person.email)
}
   


}
