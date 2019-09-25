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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
