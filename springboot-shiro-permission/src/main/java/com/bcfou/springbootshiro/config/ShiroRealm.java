package com.bcfou.springbootshiro.config;


import com.bcfou.springbootshiro.mapper.UserMapper;
import com.bcfou.springbootshiro.mapper.UserPermissionMapper;
import com.bcfou.springbootshiro.mapper.UserRoleMapper;
import com.bcfou.springbootshiro.pojo.Permission;
import com.bcfou.springbootshiro.pojo.Role;
import com.bcfou.springbootshiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserPermissionMapper userPermissionMapper;
    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        System.out.println("用户" + username + "获取权限");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色集

        List<Role> roles = userRoleMapper.findByUsername(username).getRoleid();
        Set<String> roleset = new HashSet<>();
        for (Role r : roles){
            roleset.add(r.getName());
        }
        simpleAuthorizationInfo.setRoles(roleset);
        List<Permission> permissions = new ArrayList<>();
        //获取用户权限集
        Set<String> perset = new HashSet<>();
        for (Role role: roles){
            permissions = role.getPermissionid();
            for (Permission p : permissions){
                perset.add(p.getName());
            }
        }


        simpleAuthorizationInfo.setStringPermissions(perset);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        // 通过用户名到数据库查询用户信息
        User user = userMapper.findByUsername(userName);



        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
