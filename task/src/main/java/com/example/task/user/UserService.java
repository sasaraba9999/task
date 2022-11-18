package com.example.task.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String username, String password) {
        var encodedPassword = passwordEncoder.encode(password);
        userRepository.insert(username, encodedPassword);
    }
}
