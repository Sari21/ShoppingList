package hu.sari.shoppinglist.dao;

import hu.sari.shoppinglist.model.ShoppingItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mydb")
public class FakeShoppingItemDataAccessService implements ShoppingItemDao{
    private static List<ShoppingItem> DB = new ArrayList<>();
    @Override
    public int insertShoppingItem(UUID id, ShoppingItem shoppingItem) {
        DB.add(new ShoppingItem(id, shoppingItem.getName(), shoppingItem.getPrice()));
        return 1;
    }

    @Override
    public List<ShoppingItem> selectAllShoppingItems() {
        return DB;
    }

    @Override
    public Optional<ShoppingItem> selectShoppingItemById(UUID id) {
        return DB.stream().filter(item -> item.getId().equals(id)).findFirst();

    }

    @Override
    public int deleteShoppingItemById(UUID id) {
        Optional<ShoppingItem> itemMaybe = selectShoppingItemById(id);
        if(!itemMaybe.isPresent()){
            return 0;
        }
        DB.remove(itemMaybe.get());
        return 1;
    }

    @Override
    public int buyShoppingItemById(UUID id) {
        return selectShoppingItemById(id).map(item -> {
            int indexOfItemToUpdate = DB.indexOf(item);
            if(indexOfItemToUpdate >= 0 ){
                item.buy();
               // DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                return 1;
            }
            return 0;
        })
                .orElse(0);


    }
}
