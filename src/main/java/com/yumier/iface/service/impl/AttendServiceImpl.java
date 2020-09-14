package com.yumier.iface.service.impl;

import com.yumier.iface.dao.AttendDao;
import com.yumier.iface.entity.Attend;
import com.yumier.iface.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    AttendDao attendDao;

    @Override
    public List<Attend> selectAll() {
        return attendDao.selectAll();
    }

    @Override
    public Attend selectOneUser(Attend attend) {
        return attendDao.selectOneUser(attend);
    }

    @Override
    public List<Attend> getTimeQuantum(Attend attend, Date startTime, Date endTime) {
        return attendDao.getTimeQuantum(attend, startTime, endTime);
    }

    @Override
    public int insertAttend(Attend attend) {
        return attendDao.insertAttend(attend);
    }

    @Override
    public int updateAttend(Attend attend) {
        return attendDao.updateAttend(attend);
    }

    @Override
    public int deleteOneAttend(int id) {
        return attendDao.deleteOneAttend(id);
    }

    @Override
    public int deleteOneUser(Attend attend) {
        return attendDao.deleteOneUser(attend);
    }
}
