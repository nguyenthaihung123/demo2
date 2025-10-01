package com.example.demo2.service;

import com.example.demo2.entity.UserInfo;
import com.example.demo2.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserInfoRepository userRepo;
    private final PasswordEncoder encoder;

    public UserService(UserInfoRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    // thêm user vào DB
    public String addUser(UserInfo user) {
        user.setPassword(encoder.encode(user.getPassword())); 
        userRepo.save(user);
        return "User added successfully!";
    }
}
