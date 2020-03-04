package hu.sari.shoppinglist.api;

import hu.sari.shoppinglist.dao.ShoppingItemRepository;
import hu.sari.shoppinglist.model.ShoppingItem;
import hu.sari.shoppinglist.service.ShoppingItemService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpAsyncRequestControl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("api/shoppingitem")
@RestController
public class ShoppingItemController {
    //private final ShoppingItemService shoppingItemService;
private final ShoppingItemRepository shoppingItemRepository;
    @Autowired
   /* public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }*/
    public ShoppingItemController(ShoppingItemRepository shoppingItemRepository){
    this.shoppingItemRepository = shoppingItemRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ShoppingItem addShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        //shoppingItemService.addShoppingItem(shoppingItem);
        return shoppingItemRepository.save(shoppingItem);
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public List<ShoppingItem> getAllShoppingItems() {
        Iterable<ShoppingItem> it =  shoppingItemRepository.findAll();
        List<ShoppingItem> list = new ArrayList<>();
        for(ShoppingItem s : it){
            list.add(s);
        }
        return list;
    }

    @GetMapping(path = "{id}")
    public Optional<ShoppingItem> getShoppingItemById(@PathVariable("id") int id) {
        //return shoppingItemService.getShoppingItemById(id).orElse(null);
        return shoppingItemRepository.findById(id);
    }


    @DeleteMapping(path = "{id}")
    public void deleteShoppingItemById(@PathVariable("id") int id) {
        //shoppingItemService.deleteShoppingItemById(id);
        shoppingItemRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void buyItem(@PathVariable("id") int id) {
        //shoppingItemService.buyItem(id);
         shoppingItemRepository.findById(id).get().buy();
    }


}
