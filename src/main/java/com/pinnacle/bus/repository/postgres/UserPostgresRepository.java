package com.pinnacle.bus.repository.postgres;

import com.pinnacle.bus.model.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserPostgresRepository extends JpaRepository<UserPostgres, Long> {
}
