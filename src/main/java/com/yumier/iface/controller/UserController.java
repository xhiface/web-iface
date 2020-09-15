package com.yumier.iface.controller;

import com.yumier.iface.entity.User;
import com.yumier.iface.entity.vo.DeleteUserVo;
import com.yumier.iface.entity.vo.GetUserVo;
import com.yumier.iface.entity.vo.RegisterUserVo;
import com.yumier.iface.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
@Api(tags = "获取全部用户、根据手机号获取用户、添加用户、更新用户、删除用户")
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 用户默认权限
     */
    private static final String USER_DEFAULT_ROLE = "user";

    @Autowired
    UserServiceImpl userService;

    /**
     * 获取全部用户
     *
     * @return 用户列表
     */
    @ApiOperation(value = "获取全部用户", notes = "获取成功返回用户列表，获取失败http状态码返回400")
    @PostMapping("/get-all-user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAll();
        if (userList != null && !userList.isEmpty()) {
            return ResponseEntity.ok(userList);
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * 根据手机号获取用户
     *
     * @param getUserVo {@link GetUserVo}
     * @return 查询到用户返回用户，没有查询到用户http状态码返回400
     */
    @ApiOperation(value = "根据手机号获取用户", notes = "查询到用户返回用户，没有查询到用户http状态码返回400")
    @PostMapping("/get-one-user")
    public ResponseEntity<User> getOneUser(@RequestBody GetUserVo getUserVo) {
        User user = userService.getOne(getUserVo.getPhoneNumber());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * 添加用户
     *
     * @param registerUserVo 用户
     * @return 插入用户成功返回用户，插入用户失败http状态码返回400
     */
    @ApiOperation(value = "添加用户", notes = "插入用户成功返回用户，插入用户失败http状态码返回400")
    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody RegisterUserVo registerUserVo) {
        User user = new User();
        BeanUtils.copyProperties(registerUserVo, user);
        user.setFaceId("");
        user.setRole(USER_DEFAULT_ROLE);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        if (userService.insertUser(user)) {
            return ResponseEntity.ok(userService.getOne(registerUserVo.getPhoneNumber()));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * 更新用户
     *
     * @param registerUserVo 用户
     * @return 更新用户成功返回true，更新失败http状态码返回400
     */
    @ApiOperation(value = "更新用户", notes = "更新用户成功返回true，更新失败http状态码返回400")
    @PostMapping("/update-user")
    public ResponseEntity<Boolean> updateUser(@RequestBody RegisterUserVo registerUserVo) {
        User user = new User();
        BeanUtils.copyProperties(registerUserVo, user);
        user.setUpdateTime(new Date());
        if (userService.updateUser(user)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    /**
     * 删除用户
     *
     * @param deleteUserVo 用户手机号
     * @return 删除用户成功返回true，删除失败http状态码返回400
     */
    @ApiOperation(value = "删除用户", notes = "删除用户成功返回true，删除失败http状态码返回400")
    @PostMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody DeleteUserVo deleteUserVo) {
        if (userService.deleteUser(deleteUserVo.getPhoneNumber())) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }
}
