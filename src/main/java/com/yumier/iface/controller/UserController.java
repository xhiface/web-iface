package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl us;

    @PostMapping("/getAllUser")
    public List<User> login(){
        return us.selectall();
    }

    @PostMapping("/insertUser")
    public int insertUser(@RequestBody User user){
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return us.insertUser(user);
    }

    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user){
        user.setUpdateTime(new Date());
        return us.insertUser(user);
    }

    @PostMapping("/deleteUser")
    public int deleteUser(@RequestBody User user){
        return us.deleteUser(user.getId());
    }
}
