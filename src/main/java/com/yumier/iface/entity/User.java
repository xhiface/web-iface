package com.yumier.iface.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@Data
@Table(name="t_user")//指定表名
public class User {
    @Id//主键
    @KeySql(useGeneratedKeys = true)//自动增长
    private int id;
    private String groupId;
    private String faceId;
    private String username;
    private String password;
    private String role;
    private int age;
    private String email;
    private boolean gender;
    private String phoneNumber;
    private Date createTime;
    private Date updateTime;
}
