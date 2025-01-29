package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMongoRepository extends MongoRepository<Vehicle, String> {
   
}
