package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    public Object get(){
        return (List<User>) userService.getAll();
    }

    @GetMapping("/fake")
    public List<User> getUsers(){
        return fakeDbCall();
    }

    private List<User> fakeDbCall(){

        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"sahan@bcas.lk", "sahan", "123", "USER"));
        userList.add(new User(2,"sam@gmail.com", "Sammy", "455", "ADMIN"));
        userList.add(new User(3,"anne@yahoo.com", "Anne", "789", "STAFF"));
        userList.add(new User(4,"ron@gmail.com", "Ronald", "455", "STAFF"));
        userList.add(new User(5,"will@yahoo.com", "William", "123", "USER"));

        return userList;
    }

}

