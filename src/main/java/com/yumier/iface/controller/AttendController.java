package com.yumier.iface.controller;

import com.yumier.iface.entity.Attend;
import com.yumier.iface.service.impl.AttendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author hedayu
 * @date 2020/9/13
 */
@RestController
@RequestMapping("/attend")
public class AttendController {
    @Autowired
    AttendServiceImpl asi;

    @PostMapping("/selectall")
    public List<Attend> selectAll() {
        return asi.selectAll();
    }

    @PostMapping("/selectoneuser")
    public Attend selectOneUser(@RequestBody Attend attend) {
        return asi.selectOneUser(attend);
    }

    @PostMapping("/gettimequantum")
    public List<Attend> getTimeQuantum(@RequestBody Attend attend, Date startTime, Date endTime) {
        return asi.getTimeQuantum(attend, startTime, endTime);
    }

    @PostMapping("/insertattend")
    public int insertAttend(@RequestBody Attend attend) {
        return asi.insertAttend(attend);
    }

    @PostMapping("/updateattend")
    public int updateAttend(@RequestBody Attend attend) {
        return asi.updateAttend(attend);
    }

    @PostMapping("/deleteoneattend")
    public int deleteOneAttend(int id) {
        return asi.deleteOneAttend(id);
    }

    @PostMapping("/deleteoneuser")
    public int deleteOneUser(@RequestBody Attend attend) {
        return asi.deleteOneUser(attend);
    }
}
