package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
    // MongoRepository methods for MongoDB database
}
