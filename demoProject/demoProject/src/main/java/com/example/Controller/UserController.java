package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   @Autowired
   private UserService userService;


   @PostMapping("user")
    public User addUser(@RequestBody User user){
       return userService.addUser(user);
   }
}
