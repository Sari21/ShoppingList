import { Component, OnInit } from "@angular/core";
import { ShoppingListService } from "../shopping-list.service";
import { Item } from "../item";

@Component({
  selector: "shopping-list",
  templateUrl: "./shopping-list.component.html",
  styleUrls: ["./shopping-list.component.css"]
})
export class ShoppingListComponent implements OnInit {
  newList = new Array<Item>();
  boughtList = new Array<Item>();

  constructor(private shoppingListService: ShoppingListService) {}

  ngOnInit(): void {
    this.shoppingListService.getJSON().subscribe(data => {
      data.forEach(i => {
        var v = new Item(i.id, i.name, i.price, i.isBought);
        if (v.isBought) {
          this.boughtList.push(v);
        } else {
          this.newList.push(v);
        }
      });
    });
  }
}
