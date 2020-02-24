package hu.sari.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class ShoppingItem {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final int price;

    private boolean isBought;


    public ShoppingItem(@JsonProperty("id")UUID id, @JsonProperty("name") String name, @JsonProperty("price") int price) {
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

    public UUID getId() {
        return id;
    }

    public boolean isBought() {
        return isBought;
    }

    public void buy() {
        isBought = true;
    }
}
