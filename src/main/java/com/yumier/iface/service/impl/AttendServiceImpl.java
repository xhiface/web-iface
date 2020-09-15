package com.yumier.iface.service.impl;

import com.yumier.iface.dao.AttendDao;
import com.yumier.iface.entity.Attend;
import com.yumier.iface.service.AttendService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @author intent
 * @date 2020/9/13
 */
@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    AttendDao attendDao;

    @Override
    public List<Attend> getAllAttend() {
        return attendDao.selectAll();
    }

    @Override
    public List<Attend> getOneAttend(String phoneNumber) {
        return attendDao.selectOneAttend(phoneNumber);
    }

    @Override
    public List<Attend> getTimeQuantum(Attend attend, Date startTime, Date endTime) {
        return attendDao.getTimeQuantum(attend.getPhoneNumber(), startTime, endTime);
    }

    @Override
    public boolean insertAttend(Attend attend) {
        return attendDao.insertAttend(attend) == 1;
    }

    @Override
    public boolean updateAttend(Attend attend) {
        return attendDao.updateAttend(attend) == 1;
    }

    @Override
    public boolean deleteOneAttend(int id) {
        return attendDao.deleteOneAttend(id) == 1;
    }

    @Override
    public boolean deleteOneUser(String phoneNumber) {
        return attendDao.deleteOneUser(phoneNumber) == 1;
    }
}
