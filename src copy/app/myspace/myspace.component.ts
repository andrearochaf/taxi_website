import { Component, OnInit } from '@angular/core';
import { UserService } from '@app/services/user.service';
import { Person } from '@app/models/person.model';
import { AccountService } from '@app/services/account.service';
import { ClientmessageService } from '@app/services/clientmessage.service';
import { Clientmessage } from '@app/models/clientmessage.model';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-myspace',
  templateUrl: './myspace.component.html',
  styleUrls: []
})
export class MyspaceComponent {
}
