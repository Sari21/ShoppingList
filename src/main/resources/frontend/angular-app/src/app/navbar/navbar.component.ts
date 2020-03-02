import { Component, OnInit } from "@angular/core";
import { AuthenticationService } from "../service/authentication.service";

@Component({
  selector: "navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"]
})
export class NavbarComponent implements OnInit {
  constructor(public loginService: AuthenticationService) {}

  ngOnInit(): void {}
}
