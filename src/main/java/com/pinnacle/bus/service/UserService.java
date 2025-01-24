package com.pinnacle.bus.service;

import com.pinnacle.bus.model.User;
import com.pinnacle.bus.repository.mongo.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserService(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    public List<User> getAllUsers() {
        return userMongoRepository.findAll();
    }

    public User createUser(User user) {
        return userMongoRepository.save(user);
    }

    public User updateUser(String id, User user) {
        Optional<User> existingUser = userMongoRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setId(id);
            return userMongoRepository.save(user);
        }
        return null; // Or throw an exception
    }

    public void deleteUser(String id) {
        userMongoRepository.deleteById(id);
    }
    public User getUserById(String id) {
        return userMongoRepository.findById(id).orElseThrow();
    }
    
}
