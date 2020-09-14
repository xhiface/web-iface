package com.yumier.iface.service;

import com.yumier.iface.entity.User;

import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
public interface UserService {
    List<User> selectall();
    User selectone(User user);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
