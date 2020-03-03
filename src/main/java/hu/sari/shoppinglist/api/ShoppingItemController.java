package hu.sari.shoppinglist.api;

import hu.sari.shoppinglist.model.ShoppingItem;
import hu.sari.shoppinglist.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpAsyncRequestControl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("api/shoppingitem")
@RestController
public class ShoppingItemController {
    private final ShoppingItemService shoppingItemService;

    @Autowired
    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        shoppingItemService.addShoppingItem(shoppingItem);
    }

    @GetMapping
    public Iterable<ShoppingItem> getAllShoppingItems() {

        return shoppingItemService.getAllShoppingItems();
    }

    @GetMapping(path = "{id}")
    public ShoppingItem getShoppingItemById(@PathVariable("id") int id) {
        return shoppingItemService.getShoppingItemById(id).orElse(null);
    }


    @DeleteMapping(path = "{id}")
    public void deleteShoppingItemById(@PathVariable("id") int id) {
        shoppingItemService.deleteShoppingItemById(id);
    }

    @PutMapping(path = "{id}")
    public void buyItem(@PathVariable("id") int id) {
        shoppingItemService.buyItem(id);
    }


}
