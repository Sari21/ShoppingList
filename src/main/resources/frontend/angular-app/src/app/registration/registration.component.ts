import { Component, OnInit } from "@angular/core";
import { RegistrationService } from "../registration.service";
import { User } from "../user";

@Component({
  selector: "app-registration",
  templateUrl: "./registration.component.html",
  styleUrls: ["./registration.component.css"]
})
export class RegistrationComponent implements OnInit {
  constructor(private registrationServive: RegistrationService) {}

  ngOnInit(): void {}
  onSubmit(userform) {
    var user: User;
    user = new User(
      null,
      userform.value.name,
      userform.value.email,
      userform.value.password
    );
    this.registrationServive.addUser(user);
  }
}
