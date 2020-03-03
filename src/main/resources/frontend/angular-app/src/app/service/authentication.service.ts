import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { tap, delay } from "rxjs/operators";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders
} from "@angular/common/http";
import { User } from "../user";

@Injectable({
  providedIn: "root"
})
export class AuthenticationService {
  constructor(private http: HttpClient) {}
  // isLoggedIn = false;

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
  }
  public getJSON(username): Observable<any> {
    return this.http.get("http://localhost:8080/api/user/".concat(username));
  }

  authenticate(username, password): Boolean {
    this.getJSON(username).subscribe(data => {
      var u = new User(data.id, data.name, data.email, data.password);

      if (password === u.password) {
        sessionStorage.setItem("username", username);
        console.log("true");
        return true;
      }
    });
    return false;
  }
}
