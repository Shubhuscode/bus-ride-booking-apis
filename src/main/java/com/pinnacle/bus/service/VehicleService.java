package com.pinnacle.bus.service;

import com.pinnacle.bus.model.Vehicle;
import com.pinnacle.bus.repository.VehicleMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleMongoRepository vehicleMongoRepository;

    @Autowired
    public VehicleService(VehicleMongoRepository vehicleMongoRepository) {
        this.vehicleMongoRepository = vehicleMongoRepository;
    }

    // Create or Update a Vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleMongoRepository.save(vehicle);
    }

    // Get all Vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleMongoRepository.findAll();
    }

    // Get a Vehicle by ID
    public Vehicle getVehicleById(String id) {
        return vehicleMongoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));
    }

    // Delete a Vehicle by ID
    public void deleteVehicle(String id) {
        vehicleMongoRepository.deleteById(id);
    }
}
