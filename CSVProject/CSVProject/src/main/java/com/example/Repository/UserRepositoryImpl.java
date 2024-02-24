package com.example.Repository;

import com.example.Model.User;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom{

    @Autowired
    private UserRepository userRepository;
    @Override
    public String addUsers(List<User> users) {
       if(users == null){
           return "Given list is empty..";
       }
       userRepository.saveAll(users);
       return "Users added successfully..";
    }

    @Override
    public void downloadCsv(LocalDateTime startDate, LocalDateTime endDate , HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/csv");
            String fileName = "UserDetails.csv";
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);


            CSVWriter writer = new CSVWriter(response.getWriter());
            String [] header = {"id" , "name" , "username" , "email" , "gender" , "createdAt" , "modifiedAt"};
            writer.writeNext(header);

            List<User> users = userRepository.findByCreatedAtBetween(startDate , endDate);

            //collection for loops methods using for eachEach..

            for(User user : users){
               String [] data = {user.getId() , user.getName() , user.getUsername() , user.getEmail() , user.getGender().toString() ,
                       user.getCreatedAt().toString() , user.getModifiedAt().toString() };
                writer.writeNext(data);
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
