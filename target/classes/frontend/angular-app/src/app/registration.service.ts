import { Injectable } from "@angular/core";
import { User } from "./user";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders
} from "@angular/common/http";

@Injectable({
  providedIn: "root"
})
export class RegistrationService {
  url = "http://localhost:8080/api/user";

  constructor(private http: HttpClient) {}
  public addUser(user: User) {
    this.http
      .post(this.url, user)
      .toPromise()
      .then(data => {
        console.log(data);
      });
  }
}
