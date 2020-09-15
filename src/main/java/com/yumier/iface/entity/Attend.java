package com.yumier.iface.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="t_attendancerecord")//指定表名
public class Attend {
    @Id//主键
    @KeySql(useGeneratedKeys = true)//自动增长
    private int id;
    private String username;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date checkTime;
    private String type;
    private String status;
}
