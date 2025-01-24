package com.pinnacle.bus.repository.mongo;

import com.pinnacle.bus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

// Interface for MongoDB repository
public interface UserMongoRepository extends MongoRepository<User, String> {
    // Custom query methods (if any) can be added here
}
