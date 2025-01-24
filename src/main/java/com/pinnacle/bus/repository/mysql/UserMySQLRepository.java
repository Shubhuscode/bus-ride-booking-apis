
package com.pinnacle.bus.repository.mysql;

import com.pinnacle.bus.model.UserMySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMySQLRepository extends JpaRepository<UserMySQL, Long> {
}