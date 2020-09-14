package com.yumier.iface.service;

import com.yumier.iface.entity.Attend;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
public interface AttendService {
    List<Attend> selectAll();

    List<Attend> selectOneUser(Attend attend);

    List<Attend> getTimeQuantum(Attend attend, Date startTime, Date endTime);

    int insertAttend(Attend attend);

    int updateAttend(Attend attend);

    int deleteOneAttend(int id);

    int deleteOneUser(Attend attend);
}
