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

    
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleMongoRepository.save(vehicle);
    }

   
    public List<Vehicle> getAllVehicles() {
        return vehicleMongoRepository.findAll();
    }

   
    public Vehicle getVehicleById(String id) {
        return vehicleMongoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));
    }

   
    public void deleteVehicle(String id) {
        vehicleMongoRepository.deleteById(id);
    }

    
    public Vehicle updateVehicle(String id, Vehicle vehicle) {
       
        Optional<Vehicle> existingVehicleOpt = vehicleMongoRepository.findById(id);
        
        if (existingVehicleOpt.isPresent()) {
            Vehicle existingVehicle = existingVehicleOpt.get();
           
            existingVehicle.setName(vehicle.getName());
            existingVehicle.setType(vehicle.getType());
            existingVehicle.setManufacturer(vehicle.getManufacturer());
            existingVehicle.setLicensePlate(vehicle.getLicensePlate());
            existingVehicle.setCapacity(vehicle.getCapacity());
            
            return vehicleMongoRepository.save(existingVehicle);
        } else {
            throw new RuntimeException("Vehicle not found with id " + id);
        }
}

    
}
