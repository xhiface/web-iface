package com.yumier.iface.dao;

import com.yumier.iface.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<User> selectAll();

    @Select("select * from t_user where phoneNumber=#{phoneNumber}")
    User selectOne(User user);

    @Insert("insert into t_user (groupId,faceId,username,password,age,email,gender,phoneNumber,createTime,updateTime) " +
            "value(#{groupId},#{faceId},#{username},#{password},#{age},#{email},#{gender},#{phoneNumber},#{createTime},#{updateTime})")
    int insertUser(User user);

    @Update("update t_user set ename=#{ename} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from t_user where id=#{id}")
    int deleteUser(int id);
}
