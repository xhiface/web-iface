package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.entity.vo.LoginUserVo;
import com.yumier.iface.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hedayu
 * @author intent
 * @date 2020/9/13
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 登录接口
     *
     * @param userVo 登录需要的vo
     * @return 登录成功返回登录用户，登录失败Http状态码返回400
     */
    @ApiOperation(value = "登录", notes = "登录成功返回登录用户，登录失败Http状态码返回400")
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserVo userVo) {
        if (!StringUtils.isEmpty(userVo.getPhoneNumber()) && !StringUtils.isEmpty(userVo.getPassword())) {
            User trueUser = userService.getOne(userVo.getPhoneNumber());
            if (trueUser.getPassword().equals(userVo.getPassword())) {
                return ResponseEntity.ok(trueUser);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }
}
