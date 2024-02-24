package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("users")
    public String addUsers(@RequestBody List<User> users){
        return userService.addUsers(users);
    }

    // always take date and time in string and convert it in impl
    @GetMapping("/users/csv/download")
    public ResponseEntity<String> downloadCsv(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate ,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate ,
                                         HttpServletResponse response) throws IOException {
       userService.downloadCsv(startDate , endDate , response);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
