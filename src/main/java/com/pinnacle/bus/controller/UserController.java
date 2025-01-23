package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.User;
import com.pinnacle.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/{dbType}")
    public String saveUser(@RequestBody User user, @PathVariable String dbType) {
        userService.saveUser(user, dbType);
        return "User saved to " + dbType;
    }
}
