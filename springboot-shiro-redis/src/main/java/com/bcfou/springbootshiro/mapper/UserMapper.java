package com.bcfou.springbootshiro.mapper;

import com.bcfou.springbootshiro.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, String> {

    User findByUsername(String username);
}
