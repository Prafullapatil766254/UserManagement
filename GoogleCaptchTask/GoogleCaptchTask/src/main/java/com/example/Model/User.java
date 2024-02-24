package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User{

    @Id
    private String id;

    private String username;
    private String email;
    private String password;


    private String address;
    private String mobileNo;


}
