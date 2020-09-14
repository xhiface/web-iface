package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<User> getAllUser(){
        return us.selectall();
    }

    @PostMapping("/selectoneuser")
    public User selectoneuser(@RequestBody User user){
        return us.selectone(user);
    }
    @PostMapping("/insertUser")
    public int insertUser(@RequestBody User user){
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return us.insertUser(user);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user){
        user.setUpdateTime(new Date());
        return ResponseEntity.ok(us.insertUser(user)==1);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user){
        return ResponseEntity.ok(us.deleteUser(user.getId())==1);
    }
}
