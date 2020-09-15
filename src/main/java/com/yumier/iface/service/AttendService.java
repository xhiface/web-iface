package com.yumier.iface.service;

import com.yumier.iface.entity.Attend;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
public interface AttendService {
    List<Attend> getAllAttend();

    List<Attend> getOneAttend(String phoneNumber);

    List<Attend> getTimeQuantum(Attend attend, Date startTime, Date endTime);

    boolean insertAttend(Attend attend);

    boolean updateAttend(Attend attend);

    boolean deleteOneAttend(int id);

    boolean deleteOneUser(String phoneNumber);
}
