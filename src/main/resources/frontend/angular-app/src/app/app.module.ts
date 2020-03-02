import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { ShoppingListComponent } from "./shopping-list/shopping-list.component";

import { ShoppingListService } from "./shopping-list.service";
import { NewItemModalComponent } from "./new-item-modal/new-item-modal.component";
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ShoppingListComponent,
    NewItemModalComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [ShoppingListService],
  bootstrap: [AppComponent]
})
export class AppModule {}
