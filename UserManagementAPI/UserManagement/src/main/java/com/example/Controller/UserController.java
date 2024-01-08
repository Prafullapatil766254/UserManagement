package com.example.Controller;

import com.example.Service.UserService;
import com.example.Entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;



    @PostMapping("user")
    public String addUser( @RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
