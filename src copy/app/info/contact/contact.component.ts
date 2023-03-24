import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Clientmessage } from '@app/models/clientmessage.model';
import { AlertService } from '@app/services/alert.service';
import { ClientmessageService } from '@app/services/clientmessage.service';
import { first } from 'rxjs';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  form!: FormGroup;
  clientMessage = new Clientmessage();

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private clientMessageService: ClientmessageService,
    private alertService: AlertService) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      transmitterEmail: ['', Validators.required],
      name: ['', Validators.required],
      message: ['', Validators.required],
    });
  }

  onSubmit() {

    this.clientMessage = this.form.value;
    this.clientMessage.replyDate = null;

    
    this.clientMessageService.createMessage(this.clientMessage)
      .pipe(first())
      .subscribe({
        next: () => {
          alert('Votre message a bien été envoyé.');
          
        },
        error: error => {
          alert('Votre message n\'a pas pu etre envoyé')
        }
      });
      
  }

}
