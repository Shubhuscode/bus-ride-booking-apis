package com.pinnacle.bus.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("jpa")  // Use this profile for JPA-related beans
@EnableJpaRepositories(basePackages = "com.pinnacle.bus.repository.mysql")

@EntityScan(basePackages = "com.pinnacle.bus.model")
public class JpaConfig {
}
