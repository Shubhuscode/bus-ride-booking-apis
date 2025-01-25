package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMySQLRepository extends JpaRepository<User, String> {
    // JpaRepository methods for MySQL database
}
