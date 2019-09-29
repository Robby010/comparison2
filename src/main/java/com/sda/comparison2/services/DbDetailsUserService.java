package com.sda.comparison2.services;

import com.sda.comparison2.entity.User;
import com.sda.comparison2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbDetailsUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    //This lodes the user names from the db
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("user"));


        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors
                .toList());

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }

}
