package com.imooc.hos.service.impl;

import com.imooc.hos.dao.UserDao;
import com.imooc.hos.entity.User;
import com.imooc.hos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User login(String name, String password) {
        User user=userDao.findByUserName(name);
        if (null!=user&&user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
