package com.yumier.iface.service;

import com.yumier.iface.entity.User;

import java.util.List;

/**
 * @author hedayu
 * @author intent
 * @date 2020/9/13
 */
public interface UserService {
    /**
     * 获取全部用户
     *
     * @return 全部用户
     */
    List<User> getAll();

    /**
     * 根据手机号获取一个用户
     *
     * @param phoneNumber 手机号
     * @return 用户
     */
    User getOne(String phoneNumber);

    /**
     * 插入用户
     *
     * @param registerUserVo 用户
     * @return 插入成功返回true
     */
    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String phoneNumber);
}
