package com.yumier.iface.dao;

import com.yumier.iface.entity.Attend;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@Repository
@Mapper
public interface AttendDao {
    @Select("select * from t_attendancerecord")
    List<Attend> selectAll();

    @Select("select * from t_attendancerecord where phoneNumber=#{phoneNumber}")
    List<Attend> selectOneAttend(@Param("phoneNumber") String phoneNumber);

    @Select("select * from t_attendancerecord where phoneNumber=#{phoneNumber} " +
            "and  checkTime>#{startTime} and checkTime<#{endTime}")
    List<Attend> getTimeQuantum(String phoneNumber, Date startTime, Date endTime);

    @Insert("insert into t_attendancerecord (username,phoneNumber,checkTime,type,status) " +
            "value(#{username},#{phoneNumber},#{checkTime},#{type},#{status})")
    int insertAttend(Attend attend);

    @Update("update t_attendancerecord set username=#{username},phoneNumber=#{phoneNumber}," +
            "checkTime=#{checkTime},type=#{type},status=#{status} where id=#{id}")
    int updateAttend(Attend attend);

    @Delete("delete from t_attendancerecord where id=#{id}")
    int deleteOneAttend(int id);

    @Delete("delete from t_attendancerecord where phoneNumber=#{phoneNumber}")
    int deleteOneUser(@Param("phoneNumber") String phoneNumber);
}
