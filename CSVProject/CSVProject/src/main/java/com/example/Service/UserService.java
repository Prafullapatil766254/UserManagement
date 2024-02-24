package com.example.Service;

import com.example.Model.User;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    public String addUsers(List<User> users) {
        return userRepository.addUsers(users);
    }

    public void downloadCsv(LocalDateTime startDate, LocalDateTime endDate , HttpServletResponse response) throws IOException {
        userRepository.downloadCsv(startDate , endDate ,  response);
    }
}
