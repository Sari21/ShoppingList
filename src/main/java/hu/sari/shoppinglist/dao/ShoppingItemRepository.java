package hu.sari.shoppinglist.dao;

import hu.sari.shoppinglist.model.ShoppingItem;
import org.springframework.data.repository.CrudRepository;


public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Integer>{
}
