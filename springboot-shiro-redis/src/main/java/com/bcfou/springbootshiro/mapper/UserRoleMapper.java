package com.bcfou.springbootshiro.mapper;

import com.bcfou.springbootshiro.pojo.Permission;
import com.bcfou.springbootshiro.pojo.Role;
import com.bcfou.springbootshiro.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleMapper extends JpaRepository<User, String> {
    User findByUsername(String username);

}
