package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoUserRepository implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    // Other methods similar to the earlier example
}
