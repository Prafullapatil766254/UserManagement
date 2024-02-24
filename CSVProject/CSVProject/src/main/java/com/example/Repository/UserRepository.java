package com.example.Repository;

import com.example.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> , UserRepositoryCustom{
    List<User> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
