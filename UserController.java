package com.example.demo2.controller;

import com.example.demo2.entity.UserInfo;
import com.example.demo2.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserInfo user) {
        return service.addUser(user);
    }
}
