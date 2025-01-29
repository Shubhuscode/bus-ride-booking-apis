package com.pinnacle.bus.service;

import com.pinnacle.bus.model.Location;
import com.pinnacle.bus.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Save a new location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Get location by ID
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    // Delete location by ID
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

      // Update location by ID
      public Location updateLocation(Long id, Location location) {
        // Check if the location exists
        Optional<Location> existingLocationOpt = locationRepository.findById(id);
        
        if (existingLocationOpt.isPresent()) {
            Location existingLocation = existingLocationOpt.get();
            // Update the fields you want to modify
            existingLocation.setName(location.getName()); // Update name
            existingLocation.setAddress(location.getAddress()); // Update address
            // Update other fields as needed...
            
            // Save the updated location and return it
            return locationRepository.save(existingLocation);
        } else {
            throw new RuntimeException("Location not found with id " + id);
        }
    }
}
