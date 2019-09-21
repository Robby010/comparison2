package com.sda.comparison2.services;

import com.sda.comparison2.entity.User;
import com.sda.comparison2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> get() {
        return userRepository.findAll();
    }
}
