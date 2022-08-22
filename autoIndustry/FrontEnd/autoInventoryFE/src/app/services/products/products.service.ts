import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProductsService {
  url = 'http://localhost:8081/Products';
  constructor(private http: HttpClient) {}

  getProductByName(name: string): Observable<any> {
    return this.http.get(this.url + '/findByName/' + name);
  }
}


export interface Product {
  id: string;
  name: string;
}