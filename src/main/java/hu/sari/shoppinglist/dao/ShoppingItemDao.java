package hu.sari.shoppinglist.dao;

import hu.sari.shoppinglist.model.ShoppingItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingItemDao {
    int insertShoppingItem(UUID id, ShoppingItem shoppingItem);
    default int insertShoppingItem(ShoppingItem shoppingItem){
        UUID id = UUID.randomUUID();
        return insertShoppingItem(id, shoppingItem);
    }
    List<ShoppingItem> selectAllShoppingItems();

    Optional<ShoppingItem> selectShoppingItemById(UUID id);

    int deleteShoppingItemById(UUID id);
    int buyShoppingItemById(UUID id);




}
