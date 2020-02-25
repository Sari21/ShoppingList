import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class ShoppingListService {
  //constructor(private http: HttpClient) {}
  /* list: Array<Item>;
  constructor() {
    data.forEach(i => {
      var v = new Item(i.id, i.name, i.price, i.isBouht);
      this.list.push(v);
    });
  }

  getAll(): Object {
    return this.list;

    //return this.http.get("http://localhost:8080/api/shoppingitem");
  }*/
  constructor(private http: HttpClient) {
    this.getJSON().subscribe(data => {
      console.log(data);
    });
  }

  public getJSON(): Observable<any> {
    return this.http.get("../assets/items.json");
  }
}
