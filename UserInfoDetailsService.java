package com.example.demo2.service;
import com.example.demo2.entity.UserInfo;
import com.example.demo2.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailsService implements UserDetailsService {

    private final UserInfoRepository userRepo;

    public UserInfoDetailsService(UserInfoRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        return new UserInfoDetails(user);
    }
}
