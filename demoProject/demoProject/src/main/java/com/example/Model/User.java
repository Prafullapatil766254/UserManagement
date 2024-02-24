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
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String contact;
    private String stripeCustomerId;


}
