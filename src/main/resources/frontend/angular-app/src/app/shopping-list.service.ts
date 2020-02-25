import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class ShoppingListService {
  //constructor(private http: HttpClient) {}
  list = [
    {
      id: "adbcbbc4-2cfb-4359-bdb4-c8cf220040c8",
      name: "Alma",
      price: 220,
      bought: false
    },
    {
      id: "f695492e-2603-4bc6-a463-e72964a06462",
      name: "Körte",
      price: 220,
      bought: false
    },
    {
      id: "4ba8988d-a314-43df-b0aa-8730a765f660",
      name: "Banán",
      price: 220,
      bought: false
    }
  ];

  getAll(): Object {
    return this.list;

    //return this.http.get("http://localhost:8080/api/shoppingitem");
  }
}
