import { Component, OnInit } from "@angular/core";
import { ShoppingListService } from "../shopping-list.service";
import { Item } from "../item";
import { NgModel } from "@angular/forms";

@Component({
  selector: "shopping-list",
  templateUrl: "./shopping-list.component.html",
  styleUrls: ["./shopping-list.component.css"]
})
export class ShoppingListComponent implements OnInit {
  newList: Array<Item>;
  boughtList: Array<Item>;

  constructor(private shoppingListService: ShoppingListService) {}

  ngOnInit(): void {
    this.makeLists();
  }
  buy(i): void {
    i.buy();
    this.shoppingListService.buy(i);
    this.makeLists();
  }
  makeLists() {
    this.newList = new Array<Item>();
    this.boughtList = new Array<Item>();
    this.shoppingListService.getJSON().subscribe(data => {
      data.forEach(i => {
        var v = new Item(i.id, i.name, i.price, i.bought);
        if (v.isBought) {
          this.boughtList.push(v);
        } else {
          this.newList.push(v);
        }
      });
    });
  }
  onSubmit(userform) {
    this.shoppingListService.addItem({
      name: userform.value.name,
      price: userform.value.price
    });
    this.makeLists();
  }
  deleteItem(item: Item) {
    var id = item.id;
    this.shoppingListService.deleteItem(id);
    this.makeLists();
  }
}
