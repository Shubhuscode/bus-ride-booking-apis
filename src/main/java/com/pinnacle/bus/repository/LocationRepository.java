package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
   
}
