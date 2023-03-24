import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '@app/services/account.service';
import { AlertService } from '@app/services/alert.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html',
  styleUrls: ['register.component.css']
})
export class RegisterComponent implements OnInit {

  loading = false;
  submitted = false;
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private accountService: AccountService,
    private route: ActivatedRoute,
    private alertService: AlertService

  ) { }


  ngOnInit() {
    this.form = this.formBuilder.group({
      terms: this.formBuilder.control(false, [Validators.requiredTrue]),
      age: this.formBuilder.control(false, [Validators.requiredTrue]),
      firstName: ['', Validators.required],
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  get f() {
    return this.form.controls;
  }
 
 onSubmit(){
   this.submitted = true;

      // reset alerts on submit
      this.alertService.clear();
 
     // stop here if form is invalid
     if (this.form.invalid) {
         return;
     }
 
     this.loading = true;
     this.accountService.register(this.form.value)
         .pipe(first())
         .subscribe({
             next: () => {
                 this.alertService.success('Registration successful', { keepAfterRouteChange: true });
                 this.router.navigate(['../login'], { relativeTo: this.route });
             },
             error: error => {
                 this.alertService.error(error);
                 this.loading = false;
             }
         });
   }
 
 /*
  registerUser() {

    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.loading = true;
    console.log(this.form.value)
    this.accountService.register(this.form.value)
      .subscribe({
        next: () => {
          this.alertService.success('Registration successful', { keepAfterRouteChange: true });
          this.router.navigate(['../login'], { relativeTo: this.route });
          this.form.reset();
        },
        error: error => {
          this.alertService.error(error);

        }
      })

  }
  */

}
