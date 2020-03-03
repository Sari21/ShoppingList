package hu.sari.shoppinglist.service;

import hu.sari.shoppinglist.dao.ShoppingItemRepository;
import hu.sari.shoppinglist.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingItemService {
    //private final ShoppingItemDao shoppingItemDao;
    private final ShoppingItemRepository shoppingItemRepository;

    @Autowired
  //  public ShoppingItemService(@Qualifier("mydb") ShoppingItemRepository shoppingItemRepository) {
    public ShoppingItemService( ShoppingItemRepository shoppingItemRepository) {
        //this.shoppingItemDao = shoppingItemDao;
        this.shoppingItemRepository = shoppingItemRepository;
    }

    public String addShoppingItem(ShoppingItem shoppingItem){
        //return shoppingItemDao.insertShoppingItem(shoppingItem);
        ShoppingItem s = new ShoppingItem(shoppingItem.getId(), shoppingItem.getName(), shoppingItem.getPrice());
        shoppingItemRepository.save(s);
        return "Saved";
    }
    public Iterable<ShoppingItem> getAllShoppingItems(){
       return shoppingItemRepository.findAll();
    }
    public Optional<ShoppingItem> getShoppingItemById(int id){
        //return shoppingItemDao.selectShoppingItemById(id);
       return shoppingItemRepository.findById(id);
    }
    public void deleteShoppingItemById(int id){

             shoppingItemRepository.deleteById(id);
    }
    public void buyItem(int id){
         Optional<ShoppingItem> si =shoppingItemRepository.findById(id);
        si.get().buy();



    }
}
