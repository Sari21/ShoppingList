package hu.sari.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final int id;
    @NotBlank
    private final String name;
    @NotBlank
    private final int price;

    private boolean isBought;

    public ShoppingItem(){
        this.id = 0;
        this.name = null;
        this.price = 0;
        this.isBought = false;

    }
    public ShoppingItem(@JsonProperty("id")int id, @JsonProperty("name") String name, @JsonProperty("price") int price) {
        this.id = id;
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
