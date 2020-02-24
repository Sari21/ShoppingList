import { Component, OnInit } from "@angular/core";

@Component({
  selector: "shopping-list",
  templateUrl: "./shopping-list.component.html",
  styleUrls: ["./shopping-list.component.css"]
})
export class ShoppingListComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  Heroes = [
    { id: 11, name: "Dr Nice", price: 500 },
    { id: 12, name: "Narco", price: 500 },
    { id: 13, name: "Bombasto", price: 500 },
    { id: 14, name: "Celeritas", price: 500 },
    { id: 15, name: "Magneta", price: 500 },
    { id: 16, name: "RubberMan", price: 500 },
    { id: 17, name: "Dynama", price: 500 },
    { id: 18, name: "Dr IQ", price: 500 },
    { id: 19, name: "Magma", price: 500 },
    { id: 20, name: "Tornado", price: 500 }
  ];
}
