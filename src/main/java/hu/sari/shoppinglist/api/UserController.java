package hu.sari.shoppinglist.api;


import hu.sari.shoppinglist.model.User;
import hu.sari.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

  /* @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return userService.getUserById(id).orElse(null);
    }*/

    @GetMapping(path = "{name}")
    public User getUserByUsername(@PathVariable("name") String name){
        return userService.getUserByUsername(name).orElse(null);
    }
}
