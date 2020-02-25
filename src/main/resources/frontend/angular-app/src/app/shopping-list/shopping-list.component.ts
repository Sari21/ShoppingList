import { Component, OnInit } from "@angular/core";
import { ShoppingListService } from "../shopping-list.service";

@Component({
  selector: "shopping-list",
  templateUrl: "./shopping-list.component.html",
  styleUrls: ["./shopping-list.component.css"]
})
export class ShoppingListComponent implements OnInit {
  //list: Array<any>;
  list: Object;
  constructor(private shoppingListService: ShoppingListService) {}

  ngOnInit(): void {
    this.list = this.shoppingListService.getAll();
    /*  this.shoppingListService.getAll().subscribe(data => {
      this.list = data;
      console.log(data);
    });*/
  }
}
