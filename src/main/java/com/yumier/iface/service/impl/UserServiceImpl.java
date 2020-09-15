package com.yumier.iface.service.impl;

import com.yumier.iface.dao.UserDao;
import com.yumier.iface.entity.User;
import com.yumier.iface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hedayu
 * @author intent
 * @date 2020/9/13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAll() {
        List<User> users = userDao.selectAll();
        return users;
    }

    @Override
    public User getOne(String phoneNumber) {
        User trueUser = userDao.selectOne(phoneNumber);
        return trueUser;
    }

    @Override
    public int insertUser(User user) {
        User getone = userDao.selectOne(user.getPhoneNumber());
        if (getone == null) {
            return userDao.insertUser(user);
        } else {
            return 0;
        }
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
