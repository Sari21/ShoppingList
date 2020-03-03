package hu.sari.shoppinglist.dao;

import hu.sari.shoppinglist.model.ShoppingItem;
import hu.sari.shoppinglist.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("userdb")
public class FakeUserDataAccessService  implements UserDao{
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName(), user.getEmail(), user.getPassword()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<User> selectUserByUsername(String name) {
        return DB.stream().filter(item -> item.getName().equals(name)).findFirst();
    }
}
