import { Routes } from '@angular/router';
import { AuthGuard } from '../app/guards/auth.guard';
import { LoginComponent } from './components/auth/login/login.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { SignupComponent } from './components/auth/signup/signup.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'profile', component: UserProfileComponent, canActivate: [AuthGuard] },
  { path: '', component: HomeComponent}
];
