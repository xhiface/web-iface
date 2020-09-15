package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    UserServiceImpl us;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User trueUser = us.selectone(user);
        if(trueUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok(trueUser);
        }
        return ResponseEntity.badRequest().body(null);
    }
}
