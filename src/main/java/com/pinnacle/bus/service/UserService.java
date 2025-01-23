package com.pinnacle.bus.service;

import com.pinnacle.bus.model.User;
import com.pinnacle.bus.repository.MongoUserRepository;
import com.pinnacle.bus.repository.MysqlUserRepository;
import com.pinnacle.bus.repository.PostgresUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PostgresUserRepository postgresRepo;

    @Autowired
    private MysqlUserRepository mysqlRepo;

    @Autowired
    private MongoUserRepository mongoRepo;

    public void saveUser(User user, String dbType) {
        switch (dbType.toLowerCase()) {
            case "postgres":
                postgresRepo.save(user);
                break;
            case "mysql":
                mysqlRepo.save(user);
                break;
            case "mongo":
                mongoRepo.save(user);
                break;
            default:
                throw new IllegalArgumentException("Unsupported DB type");
        }
    }
}
