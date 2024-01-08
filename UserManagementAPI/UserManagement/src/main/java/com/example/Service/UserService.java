package com.example.Service;

import com.example.Entity.User;
import com.example.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

     @Autowired
     IUserRepo userRepo;
    public String addUser(User user) {
        userRepo.save(user);
        return "User Added Successfully..";
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
