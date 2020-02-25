export class Item {
  id: String;
  name: String;
  price: number;
  isBought: boolean;
  constructor(id, name, price, isBought) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.isBought = isBought;
  }
  buy() {
    this.isBought = true;
  }
}
