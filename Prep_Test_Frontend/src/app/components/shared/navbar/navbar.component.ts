import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth/auth.service';
import { Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    MatToolbarModule,
    NgIf,
    RouterLink
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(private authService: AuthService, private router: Router) { }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
}
