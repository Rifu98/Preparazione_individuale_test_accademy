import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = `${environment.apiUrl}/auth`;

  constructor(private http: HttpClient) { }

  signUp(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, data);
  }

  signIn(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signin`, data);
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }
}
