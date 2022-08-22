import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductsService } from '../products/products.service';
import { UsersService } from '../users/users.service';

@Injectable({
  providedIn: 'root',
})
export class InventoryService {
  url = 'http://localhost:8081/Inventory';
  constructor(private http: HttpClient) {}

  getInventory(): Observable<any> {
    return this.http.get(this.url + '/all');
  }

  getInventoryByProduct(text: string): Observable<any> {
    return this.http.get(this.url + '/allByProduct/' + text);
  }

  getInventoryItem(id: string): Observable<any> {
    return this.http.get(this.url + '/find/' + id);
  }

  saveInventoryItem(inventory: Inventory): Observable<any> {
    return this.http.post(this.url + '/save/', inventory);
  }

  editInventoryItem(id: string, inventory: Inventory): Observable<any> {
    return this.http.put(this.url + '/save/' + id, inventory);
  }

  deleteIventoryItem(id: string):Observable<any> {
    return this.http.delete(this.url + '/delete/' + id);
  }
}

export interface Inventory {
  id: string;
  created_date: string;
  quantity: string;
  updated_date: string;
  product: Object;
  user: Object;
}


/*
PRODUCTOS SAVE
{
	"name": "Transmision ZXASD100"
}

USUARIO SAVE
{
	"name": "Sebastian",
	"lastname": "Serrano",
	"position": "Administrador de bodega",
	"age": "28",
	"created_date": "2022-08-19", 
	"updated_date": "2022-08-19"
}

INVENTARIO SAVE
{
	"created_date": "2022-08-19",
	"quantity": "2",
	"product": "1",
	"updated_date": "2022-08-19",
	"user": "1"
}

*/