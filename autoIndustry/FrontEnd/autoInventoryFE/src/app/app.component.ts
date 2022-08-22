import { Component, NgModule, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {} from '@angular/forms';
import { Router } from '@angular/router';
import {
  Inventory,
  InventoryService,
} from './services/inventory/inventory.service';
import { Product, ProductsService } from './services/products/products.service';
import { User, UsersService } from './services/users/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  listInventory: any = [];
  listUsers: any = [];
  productsNew: any = {
    name: '',
  };

  filterargs: any = {
    title: ''
  };
  
  userSelected: any = {
    value: '',
  };

  userSesionSelected: any = {
    value: '',
  };

  inventoryAdd: Inventory = {
    id: '',
    created_date: '',
    quantity: '',
    updated_date: '',
    product: '',
    user: '',
  };

  productEdit: Product = {
    id: '',
    name: '',
  };

  userEdit: User = {
    id: '',
    name: '',
    lastname: '',
    position: '',
    age: '',
    created_date: '',
    updated_date: '',
  };

  userEditValue: any = {
    value: '',
  };

  inventoryEdit: Inventory = {
    id: '',
    created_date: '',
    quantity: '',
    updated_date: '',
    product: '',
    user: '',
  };

  /*product: {
      name: ''
    },*/
  /*user: {
      age: '',
      created_date: '',
      lastname: '',
      name:'',
      position: '',
      updated_date: ''
    }*/

  inventoryForm!: FormGroup;

  constructor(
    public fb: FormBuilder,
    public inventoryService: InventoryService,
    public productsService: ProductsService,
    public userService: UsersService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.inventoryForm = this.fb.group({
      id: ['', Validators.required],
      product: ['', Validators.required],
      quantity: ['', Validators.required, Validators.pattern('^[0-9]*$')],
      created_date: ['', Validators.required],
      updated_date: ['', Validators.required],
      user: ['', Validators.required],
    });

    this.inventoryList();
    this.usersList();
  }

  inventoryList() {
    this.inventoryService.getInventory().subscribe(
      (res) => {
        this.listInventory = res;

        console.log(res);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  usersList() {
    this.userService.getUsers().subscribe(
      (res) => {
        this.listUsers = res;
        console.log(res);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  delete(id: string) {
    var user = this.userSesionSelected.value;
    console.log('Usuario en sesion: ' + user);
    if (!user || user == null) {
      alert('No ha seleccionado el usuario para validacion de sesión');
    } else {
      this.inventoryService.getInventoryItem(id).subscribe(
        (res) => {
          console.log('Usuario del producto a eliminar: ' + res.user.id);
          console.log(user.split(' ')[0]);
          if (user.split(' ')[0] == res.user.id) {
            if (
              confirm(
                'El usuario de sesión coincide con el usuario seleccionado, desea eliminar la mercancía.'
              )
            ) {
              console.log('Se eliminara el id:' + id);
              this.inventoryService.deleteIventoryItem(id).subscribe(
                (res) => {
                  this.ngOnInit();
                },
                (err) => {
                  console.log('Error: ' + err.message);
                }
              );
            } else {
              // Do nothing!
              this.ngOnInit();
            }
          } else {
            alert(
              'Para eliminar mercancía, solo lo puede hacer el usuario que la registró'
            );
          }
        },
        (err) => {
          console.log('Error: ' + err.message);
        }
      );
    }
  }

  saveInventory(): boolean {
    // Validar si existe mercancia con el mismo nombre
    var product = this.productsNew.name;
    console.log('Producto: ' + product);
    if (!product || product == null) {
      alert('No ha diligenciado el producto');
      return false;
    } else {
      this.productsService.getProductByName(product).subscribe(
        (res) => {
          console.log(res);
          if (res == null) {
            console.log('No se encontraron registros en la base de datos');
            this.inventoryAdd.product = {
              name: product,
            };
            // Validar cantidad
            var quantity = this.inventoryAdd.quantity;
            console.log('Cantidad: ' + quantity);
            if (!quantity || quantity == null) {
              alert('No ha diligenciado la cantidad');
            } else {
              if (
                quantity.toString().includes(',') ||
                quantity.toString().includes('.')
              ) {
                alert(
                  'La cantidad debe ser un número entero (Sin tildes o puntos)'
                );
              } else {
                // Validar fecha de creacion
                var created_date = this.inventoryAdd.created_date;
                console.log('Fecha de ingreso: ' + created_date);
                if (!created_date || created_date == null) {
                  alert('No ha diligenciado la fecha de ingreso');
                } else {
                  console.log('AÑO: ' + created_date.split('-')[0]);
                  console.log('MES: ' + created_date.split('-')[1]);
                  console.log('DIA: ' + created_date.split('-')[2]);

                  var today = new Date();
                  var dateNow = new Date(
                    today.getFullYear(),
                    today.getMonth() + 1,
                    today.getDate()
                  );
                  var dateWrited = new Date(
                    parseInt(created_date.split('-')[0]),
                    parseInt(created_date.split('-')[1]),
                    parseInt(created_date.split('-')[2])
                  );

                  console.log('dateNow: ' + dateNow.getTime());
                  console.log('dateWrited: ' + dateWrited.getTime());

                  if (dateWrited.getTime() > dateNow.getTime()) {
                    alert(
                      'La fecha de ingreso debe ser menor o igual a la fecha actual'
                    );
                  } else {
                    // Validar usuario y asignar valores de usuario
                    var user = this.userSelected.value;
                    console.log('Usuario: ' + user);
                    if (!user || user == null) {
                      alert('No ha diligenciado el usuario');
                    } else {
                      var userParts = user.split(' ');
                      this.userService.getUser(userParts[0]).subscribe(
                        (res) => {
                          this.inventoryAdd.user = res;
                          console.log(res);
                          console.log(
                            'DATOS A GUARDAR: ' +
                              JSON.stringify(this.inventoryAdd)
                          );
                          // Crear regisrtro en base de datos
                          this.inventoryService
                            .saveInventoryItem(this.inventoryAdd)
                            .subscribe(
                              (res) => {
                                console.log(res);
                                window.location.reload();
                              },
                              (err) => {
                                console.log(err);
                              }
                            );
                        },
                        (err) => {
                          console.log(err);
                        }
                      );
                    }
                  }
                }
              }
            }
          } else {
            alert(
              'No puede existir mas de una mercancía con el mismo nombre, por favor verificar producto.'
            );
          }
        },
        (err) => {
          console.log(err);
        }
      );
    }
    return true;
  }

  getInventory(id: string) {
    this.inventoryService.getInventoryItem(id).subscribe(
      (res) => {
        console.log('getInventory: ' + JSON.stringify(res));
        this.inventoryEdit = res;
        this.productEdit = res.product;
        this.userEdit = res.user;
        this.userEditValue.value =
          this.userEdit.id +
          ' ' +
          this.userEdit.name +
          ' ' +
          this.userEdit.lastname;
        this.userSelected.value = this.userEditValue.value;
        console.log('--> I:' + JSON.stringify(this.inventoryEdit));
        console.log('--> P:' + JSON.stringify(this.productEdit));
        console.log('--> U:' + JSON.stringify(this.userEdit));
        console.log('- ' + this.userEditValue.value);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  editInventory(): boolean {
    // Validar si existe mercancia con el mismo nombre
    var product = this.productEdit.name;
    console.log('Producto: ' + product);
    if (!product || product == null) {
      alert('No ha diligenciado el producto');
      return false;
    } else {
      this.productsService.getProductByName(product).subscribe(
        (res) => {
          console.log(res);
          this.inventoryEdit.product = {
            name: product,
          };
          // Validar cantidad
          var quantity = this.inventoryEdit.quantity;
          console.log('Cantidad: ' + quantity);
          if (!quantity || quantity == null) {
            alert('No ha diligenciado la cantidad');
          } else {
            if (
              quantity.toString().includes(',') ||
              quantity.toString().includes('.')
            ) {
              alert(
                'La cantidad debe ser un número entero (Sin tildes o puntos)'
              );
            } else {
              // Validar fecha de creacion
              var created_date = this.inventoryEdit.created_date;
              console.log('Fecha de ingreso: ' + created_date);
              if (!created_date || created_date == null) {
                alert('No ha diligenciado la fecha de ingreso');
              } else {
                console.log('AÑO: ' + created_date.split('-')[0]);
                console.log('MES: ' + created_date.split('-')[1]);
                console.log('DIA: ' + created_date.split('-')[2]);

                var today = new Date();
                var dateNow = new Date(
                  today.getFullYear(),
                  today.getMonth() + 1,
                  today.getDate()
                );
                var dateWrited = new Date(
                  parseInt(created_date.split('-')[0]),
                  parseInt(created_date.split('-')[1]),
                  parseInt(created_date.split('-')[2])
                );

                console.log('dateNow: ' + dateNow.getTime());
                console.log('dateWrited: ' + dateWrited.getTime());

                if (dateWrited.getTime() > dateNow.getTime()) {
                  alert(
                    'La fecha de ingreso debe ser menor o igual a la fecha actual'
                  );
                } else {
                  // Validar usuario y asignar valores de usuario
                  var user = this.userSelected.value;
                  console.log('Usuario: ' + user);
                  if (!user || user == null) {
                    alert('No ha diligenciado el usuario');
                  } else {
                    var userParts = user.split(' ');
                    this.userService.getUser(userParts[0]).subscribe(
                      (res) => {
                        this.inventoryEdit.user = res;
                        console.log(res);
                        console.log(
                          'DATOS A GUARDAR: ' +
                            JSON.stringify(this.inventoryEdit)
                        );
                        // Crear regisrtro en base de datos
                        this.inventoryService
                          .editInventoryItem(this.inventoryEdit.id,this.inventoryEdit)
                          .subscribe(
                            (res) => {
                              console.log(res);
                              window.location.reload();
                            },
                            (err) => {
                              console.log(err);
                            }
                          );
                      },
                      (err) => {
                        console.log(err);
                      }
                    );
                  }
                }
              }
            }
          }
                    /*
          if (res == null) {
          }
          else {
            alert(
              'No puede existir mas de una mercancía con el mismo nombre, por favor verificar producto.'
            );
          }*/
        },
        (err) => {
          console.log(err);
        }
      );
    }

    return true;
  }

  filterProduct(x: any) {
    var value = x.target.value;
    var counter = 1;
    var listInventoryTemp: any[] = [];
    this.inventoryService.getInventory().subscribe(
      (res) => {
        this.listInventory = res;
        console.log(this.listInventory);
        console.log(this.listInventory.length);
        this.listInventory.forEach((element: any) => {
          if(element.product.name.includes(value)) {
            console.log(element.product.name);
            listInventoryTemp.push(element)
          }
          /*else if (counter!=1 && element.product.name.includes(value)){
            console.log(element.product.name);
            this.listInventory.push(element);
          }*/
          counter++;
        });
      },
      (err) => {
        console.log(err);
      }
    );

    this.listInventory = {};
    

    

    // [(ngModel)]="filterargs.name" 
    //(keyup)="filterProduct($event)"
    /*var value = x.target.value;
    this.inventoryService.getInventoryByProduct(value).subscribe(
      (res) => {
        //this.listInventory = res;
        console.log("Valor: " + value + " | Filter: " + res);
      },
      (err) => {
        console.log(err);
      }
    );*/
  }
}
