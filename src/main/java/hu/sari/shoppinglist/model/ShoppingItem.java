package hu.sari.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Random;

@Entity
@Table
public class ShoppingItem {
    @Id
    private final int id;
    private final String name;
    private final int price;

    private boolean isBought;

    public ShoppingItem(){
        this.id = 0;
        this.name = null;
        this.price = 0;
        this.isBought = false;

    }
    public ShoppingItem( @JsonProperty("name") String name, @JsonProperty("price") int price) {
        Random rn = new Random();
        this.id = rn.nextInt();
        this.name = name;
        this.price = price;
        this.isBought = false;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean getIsBought() {
        return isBought;
    }

    public void buy() {
        isBought = true;
    }
}
