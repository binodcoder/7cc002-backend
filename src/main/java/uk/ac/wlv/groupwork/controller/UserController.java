package uk.ac.wlv.groupwork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.service.UserService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    //FAKE DATABASE for testing purposes.
    @GetMapping("/fake")
    public List<User> getUsers(){
        return fakeDbCall();
    }

    private List<User> fakeDbCall(){

        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"sahan@bcas.lk", "sahan", "123", "USER", 33));
        userList.add(new User(2,"sam@gmail.com", "Sammy", "455", "ADMIN", 22));
        userList.add(new User(3,"anne@yahoo.com", "Anne", "789", "STAFF", 33));
        userList.add(new User(4,"ron@gmail.com", "Ronald", "455", "STAFF",22));
        userList.add(new User(5,"will@yahoo.com", "William", "123", "USER", 22));

        return userList;
    }

}

