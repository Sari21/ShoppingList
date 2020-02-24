package hu.sari.shoppinglist.service;

import hu.sari.shoppinglist.dao.ShoppingItemDao;
import hu.sari.shoppinglist.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingItemService {
    private final ShoppingItemDao shoppingItemDao;

    @Autowired
    public ShoppingItemService(@Qualifier("mydb") ShoppingItemDao shoppingItemDao) {
        this.shoppingItemDao = shoppingItemDao;
    }

    public int addShoppingItem(ShoppingItem shoppingItem){
        return shoppingItemDao.insertShoppingItem(shoppingItem);
    }
    public List<ShoppingItem> getAllShoppingItems(){
        return shoppingItemDao.selectAllShoppingItems();
    }
    public Optional<ShoppingItem> getShoppingItemById(UUID id){
        return shoppingItemDao.selectShoppingItemById(id);
    }
    public int deleteShoppingItemById(UUID id){
        return shoppingItemDao.deleteShoppingItemById(id);
    }
    public int buyItem(UUID id){
        return shoppingItemDao.buyShoppingItemById(id);
    }
}
