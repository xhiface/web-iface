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
 * @author intent
 * @date 2020/9/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl us;

    @PostMapping("/get-all-user")
    public List<User> getAllUser() {
        return us.getAll();
    }

    @PostMapping("/select-one-user")
    public User selectOneUser(@RequestBody User user) {
        return us.getOne(user.getPhoneNumber());
    }

    @PostMapping("/insert-user")
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        user.setFaceId("");
        user.setRole("user");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        if (us.insertUser(user) == 1) {
            return ResponseEntity.ok(us.getOne(user.getPhoneNumber()));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/update-user")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user) {
        user.setUpdateTime(new Date());
        return ResponseEntity.ok(us.insertUser(user) == 1);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
        return ResponseEntity.ok(us.deleteUser(user.getId()) == 1);
    }
}
