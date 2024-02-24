package com.example.Repository;

import com.example.Model.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface UserRepositoryCustom {

    String addUsers(List<User> users);
   void downloadCsv(LocalDateTime startDate, LocalDateTime endDate , HttpServletResponse response) throws IOException;
}
