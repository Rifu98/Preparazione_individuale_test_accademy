import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth/auth.service';
import { Router } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';


@Component({
    selector: 'app-signup',
    standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule
  ],
    templateUrl: './signup.component.html',
    styleUrl: './signup.component.css'
})
export class SignupComponent {
    signupForm: FormGroup;

    constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
        this.signupForm = this.fb.group({
            nome: ['', [Validators.required]],
            cognome: ['', [Validators.required]],
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$')]],
            codiceInvito: ['']
        });
    }

    onSubmit(): void {
        if (this.signupForm.valid) {
            this.authService.signUp(this.signupForm.value).subscribe(
                response => {
                    this.router.navigate(['/login']);
                },
                error => {
                    console.error(error);
                }
            );
        }
    }

}
