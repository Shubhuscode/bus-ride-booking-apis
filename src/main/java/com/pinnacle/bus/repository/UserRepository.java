package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // You can add custom query methods here if needed
}
