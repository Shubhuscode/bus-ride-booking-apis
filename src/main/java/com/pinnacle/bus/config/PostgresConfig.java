package com.pinnacle.bus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("postgres")
@EnableJpaRepositories(basePackages = "com.pinnacle.bus.repository.postgres")
public class PostgresConfig {
    // Any additional PostgreSQL configuration if needed
}
