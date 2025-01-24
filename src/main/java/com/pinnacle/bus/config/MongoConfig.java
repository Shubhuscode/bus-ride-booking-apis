package com.pinnacle.bus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongo")  // Use this profile for MongoDB-related beans
@EnableMongoRepositories(basePackages = "com.pinnacle.bus.repository.mongo")
public class MongoConfig {
}

