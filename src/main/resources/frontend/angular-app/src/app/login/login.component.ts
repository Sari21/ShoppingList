import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthenticationService } from "../service/authentication.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
}) //implements OnInit
export class LoginComponent {
  /* username = "javainuse";
  password = "";
  invalidLogin = false;*/
  message: string;

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {
    this.setMessage();
  }

  /*ngOnInit(): void {}
  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password)) {
      this.router.navigate([""]);
      this.invalidLogin = false;
    } else this.invalidLogin = true;
  }*/
  setMessage() {
    this.message = "Logged " + (this.authService.isLoggedIn ? "in" : "out");
  }

  login() {
    this.message = "Trying to log in ...";

    this.authService.login().subscribe(() => {
      this.setMessage();
      if (this.authService.isLoggedIn) {
        // Usually you would use the redirect URL from the auth service.
        // However to keep the example simple, we will always redirect to `/admin`.
        const redirectUrl = "/admin";

        // Redirect the user
        this.router.navigate([redirectUrl]);
      }
    });
  }

  logout() {
    this.authService.logout();
    this.setMessage();
  }
}
