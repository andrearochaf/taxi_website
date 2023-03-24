import { Component, OnInit } from '@angular/core';
import { Person } from '@app/models/person.model';
import { AccountService } from '@app/services/account.service';
import { UserService } from '@app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: []
})
export class HeaderComponent implements OnInit{
  
  
  isConnected: boolean;
  person?: Person | null;

    constructor(private accountService: AccountService, private userService: UserService) {
    }


  ngOnInit(): void {
    this.isConnected = this.userService.getUserLoggedIn();
  }
 
   
    logout() {
        this.accountService.logout();
    }
}
