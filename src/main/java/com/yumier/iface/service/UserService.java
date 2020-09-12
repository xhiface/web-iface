package com.yumier.iface.service;

import com.yumier.iface.dao.UserDao;
import com.yumier.iface.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao ud;

    public List<User> selectall(){
        List<User> users = ud.selectAll();
        return users;
    }
    public User selectone(User user){
        User trueUser = ud.selectOne(user);
        return trueUser;
    }
    public int insertUser(User user){
        return ud.insertUser(user);
    }
}
