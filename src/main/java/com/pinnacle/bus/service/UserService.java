package com.pinnacle.bus.service;

import com.pinnacle.bus.model.User;
import com.pinnacle.bus.repository.UserMongoRepository;
import com.pinnacle.bus.repository.UserMySQLRepository;
import com.pinnacle.bus.repository.UserPostgreSQLRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserPostgreSQLRepository userPostgreSQLRepository;
    private final UserMySQLRepository userMySQLRepository;
    private final UserMongoRepository userMongoRepository;

    public UserService(UserPostgreSQLRepository userPostgreSQLRepository, 
                       UserMySQLRepository userMySQLRepository, 
                       UserMongoRepository userMongoRepository) {
        this.userPostgreSQLRepository = userPostgreSQLRepository;
        this.userMySQLRepository = userMySQLRepository;
        this.userMongoRepository = userMongoRepository;
    }

    public User createUser(User user) {
        return userPostgreSQLRepository.save(user);  // Save only in PostgreSQL
    }

    public User updateUser(String id, User userDetails) {
        User user = getUserById(id);  // Fetch user from PostgreSQL
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setUpdatedAt(userDetails.getUpdatedAt());
        return userPostgreSQLRepository.save(user);  // Save only in PostgreSQL
    }

    public void deleteUser(String id) {
        userPostgreSQLRepository.deleteById(id);  // Delete only from PostgreSQL
    }

    public List<User> getAllUsers() {
        return userPostgreSQLRepository.findAll();
    }
    // Method to retrieve all users from all databases
    public List<User> getAllUsersFromAllDatabases() {
        List<User> allUsers = new ArrayList<>();
        
        // Retrieve users from PostgreSQL
        allUsers.addAll(userPostgreSQLRepository.findAll());
        
        // Retrieve users from MySQL
        allUsers.addAll(userMySQLRepository.findAll());
        
        // Retrieve users from MongoDB
        allUsers.addAll(userMongoRepository.findAll());
        
        return allUsers;
    }

    // You might also need a method to fetch user by id from PostgreSQL
    public User getUserById(String id) {
        return userPostgreSQLRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
