package hu.sari.shoppinglist.service;


import hu.sari.shoppinglist.dao.UserDao;
import hu.sari.shoppinglist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userdb") UserDao userDao) {
        this.userDao    = userDao;
    }

    public int addUser(User user){
        return userDao.insertUser(user);
    }
    public List<User> getAllUsers(){
        return userDao.selectAllUsers();
    }
    public Optional<User> getUserById(UUID id){
        return userDao.selectUserById(id);
    }
    public Optional<User> getUserByUsername(String name){
        return userDao.selectUserByUsername(name);
    }
}
