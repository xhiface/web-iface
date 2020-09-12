package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/system")
public class loginCon {

    @Autowired
    userService us;

    @PostMapping("/login")
    public Boolean login(User user){
        User trueUser = us.selectone(user);
        if(trueUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
