import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders
} from "@angular/common/http";
import { Observable } from "rxjs";
import { Item } from "./item";

import { catchError, retry } from "rxjs/operators";
import { error } from "@angular/compiler/src/util";

@Injectable({
  providedIn: "root"
})
export class ShoppingListService {
  url = "http://localhost:8080/api/shoppingitem";

  constructor(private http: HttpClient) {
    this.getJSON().subscribe(data => {
      console.log(data);
    });
    /* this.http
      .post(this.url, this.postData)
      .toPromise()
      .then(data => {
        console.log(data);
      });*/
  }

  httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json",
      Authorization: "my-auth-token"
    })
  };

  public getJSON(): Observable<any> {
    return this.http.get("http://localhost:8080/api/shoppingitem");
  }
  public buy(item: Item) {
    this.http
      .put(this.url.concat("/").concat(item.id), item)
      .toPromise()
      .then(data => {
        console.log(data);
      });
  }

  public addItem(newItem) {
    this.http
      .post(this.url, newItem)
      .toPromise()
      .then(data => {
        console.log(data);
      });
  }

  public deleteItem(id) {
    this.http
      .delete(this.url.concat("/").concat(id))
      .toPromise()
      .then(data => {
        console.log(data);
      });
  }
}
