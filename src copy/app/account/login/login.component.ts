import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AccountService } from '@app/services/account.service';
import { AlertService } from '@app/services/alert.service';
import { UserService } from '@app/services/user.service';
import { Person } from '@app/models/person.model';



@Component({
    templateUrl: 'login.component.html',
    selector: 'app-login',
    styleUrls: ['./login.component.css', './signin.css']
})
export class LoginComponent implements OnInit {
    form!: FormGroup;
    loading = false;
    submitted = false;
    connectedPerson: Person;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private accountService: AccountService,
        private alertService: AlertService,
        private userService: UserService
    ) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.form.invalid) {
            alert("wrong credentials. please try again")
            return;
        }

        this.loading = true;
        this.accountService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe({
                next: () => {
                    // get return url from query parameters or default to home page
                    this.userService.setUserLoggedIn();
                    this.userService.setUsername(this.f.username.value);
                    this.accountService.getByUsername(this.f.username.value)
                    .subscribe(res=>{
                        if (res.authorities[0].name == "ADMIN"){
                            this.router.navigate(['/myspace/admin']);
                        }else {
                            this.router.navigate(['/myspace/client']);
                        }
                    })

                    
                    
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });
    }
}
