import { Component, OnInit } from '@angular/core';
import { ClientmessageService } from '@app/services/clientmessage.service';
import { UserService } from '@app/services/user.service';
import { first } from 'rxjs';

@Component({
  selector: 'app-adminspace',
  templateUrl: './adminspace.component.html',
  styleUrls: ['./adminspace.component.css']
})
export class AdminspaceComponent implements OnInit{
  clientMessages?: any[];

  constructor(public userService: UserService, private clientmessageService: ClientmessageService) { }

  ngOnInit(): void {
    this.clientmessageService.getAll()
    .pipe(first())
            .subscribe(users => this.clientMessages = users);
  }

}
