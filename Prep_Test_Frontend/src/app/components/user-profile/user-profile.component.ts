import { Component } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [
    MatCardModule
  ],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  user: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserProfile().subscribe(
      (response: any) => {
        this.user = response;
        console.log(this.user)
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

}
