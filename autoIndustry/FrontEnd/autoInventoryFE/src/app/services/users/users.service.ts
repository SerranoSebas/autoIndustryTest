import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  url = 'http://localhost:8081/Users';
  constructor(private http: HttpClient) {}

  getUsers(): Observable<any> {
    return this.http.get(this.url + '/all');
  }

  getUser(id: string): Observable<any> {
    return this.http.get(this.url + '/find/' + id);
  }

  saveUser(inventory: User): Observable<any> {
    return this.http.post(this.url + '/save/', inventory);
  }

  editUser(id: string, inventory: User): Observable<any> {
    return this.http.put(this.url + '/save/', inventory);
  }

  deleteUser(id: string): Observable<any> {
    return this.http.delete(this.url + '/' + id);
  }

}

export interface User {
  id: string;
  name: string;
  lastname: string;
  position: string;
  age: string;
  created_date: string;
  updated_date: string;
}