import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = `${environment.apiUrl}/users`;

  constructor(private http: HttpClient) { }

  getUserProfile(): Observable<any> {
    const userId = localStorage.getItem('userId');
    return this.http.get(`${this.apiUrl}/${userId}`);
  }
}
