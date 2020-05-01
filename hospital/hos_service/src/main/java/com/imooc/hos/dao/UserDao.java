package com.imooc.hos.dao;

import com.imooc.hos.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    User findByUserName(String username);
}
