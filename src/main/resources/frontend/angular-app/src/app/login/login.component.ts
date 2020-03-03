import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthenticationService } from "../service/authentication.service";
import { NgForm, NgModel, FormGroup, FormBuilder } from "@angular/forms";
import { NgbActiveModal } from "@ng-bootstrap/ng-bootstrap";
import { Output, EventEmitter, Input } from "@angular/core";
import { FormControl, Validators } from "@angular/forms";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
}) //implements OnInit
export class LoginComponent {
  invalidLogin = false;
  myForm: FormGroup;

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {}

  /*onSubmit(userform) {
    this.shoppingListService.addItem({
      name: userform.value.name,
      price: userform.value.price
    });
    this.makeLists();
  }*/
  ngOnInit(): void {}
  onSubmit(userform) {
    console.log(userform);
    if (
      this.authService.authenticate(
        userform.value.name,
        userform.value.password
      )
    ) {
      this.router.navigate([""]);
      this.invalidLogin = false;
    } else this.invalidLogin = true;
  }
}
