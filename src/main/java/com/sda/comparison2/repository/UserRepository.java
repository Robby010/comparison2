package com.sda.comparison2.repository;

import com.sda.comparison2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);
}
