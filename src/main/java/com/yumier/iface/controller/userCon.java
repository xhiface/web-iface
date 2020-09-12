package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userCon {

    @Autowired
    userService us;

    @GetMapping("/getAllUser")
    public List<User> login(){
        List<User> userList = us.selectall();
        return userList;
    }

    @GetMapping("/insertUser")
    public int insertUser(User user){
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return us.insertUser(user);
    }
}
