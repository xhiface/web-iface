package com.yumier.iface.dao;

import com.yumier.iface.entity.User;
import com.yumier.iface.entity.vo.RegisterUserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hedayu
 * @author intent
 * @date 2020/9/13
 */
@Repository
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<User> selectAll();

    @Select("select * from t_user where phoneNumber=#{phoneNumber}")
    User selectOne(@Param("phoneNumber") String phoneNumber);

    @Insert("insert into t_user (groupId,faceId,username,password,role,age,email,gender,phoneNumber,createTime,updateTime) " +
            "value(#{groupId},#{faceId},#{username},#{password},#{role},#{age},#{email},#{gender},#{phoneNumber},#{createTime},#{updateTime})")
    int insertUser(User user);

    @Update("update t_user set groupId = #{groupId},faceId = #{faceId},username = #{username},password = #{password},role = #{role},age = #{age},email = #{email},gender = #{gender}," +
            "phoneNumber = #{phoneNumber},createTime = #{createTime},updateTime = #{updateTime} where phoneNumber=#{phoneNumber}")
    int updateUser(User user);

    @Delete("delete from t_user where phoneNumber=#{phoneNumber}")
    int deleteUser(@Param("phoneNumber") String phoneNumber);
}
