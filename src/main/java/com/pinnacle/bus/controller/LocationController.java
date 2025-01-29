package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.Location;
import com.pinnacle.bus.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Create a new location
    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    // Get all locations
    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    // Get location by ID
    @GetMapping("/{id}")
    public Optional<Location> getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

     // Update location by ID
     @PutMapping("/{id}")
     public Location updateLocation(@PathVariable Long id, @RequestBody Location location) {
         // Assuming you have a method in LocationService to update the location
         return locationService.updateLocation(id, location);
     }
 

    // Delete location by ID
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
