package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // You can define custom queries here if needed, e.g., find by name or address
}
