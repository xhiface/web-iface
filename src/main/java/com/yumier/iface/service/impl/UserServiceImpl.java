package com.yumier.iface.service.impl;

import com.yumier.iface.dao.UserDao;
import com.yumier.iface.entity.User;
import com.yumier.iface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao ud;

    @Override
    public List<User> selectall(){
        List<User> users = ud.selectAll();
        return users;
    }
    @Override
    public User selectone(User user){
        User trueUser = ud.selectOne(user);
        return trueUser;
    }
    @Override
    public int insertUser(User user){
        return ud.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return ud.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return ud.deleteUser(id);
    }
}
