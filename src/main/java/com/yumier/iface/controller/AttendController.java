package com.yumier.iface.controller;

import com.yumier.iface.entity.Attend;
import com.yumier.iface.entity.TimeQuantum;
import com.yumier.iface.entity.User;
import com.yumier.iface.service.impl.AttendServiceImpl;
import com.yumier.iface.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    @Autowired
    UserServiceImpl usi;

    @PostMapping("/selectall")
    public List<Attend> selectAll() {
        return asi.selectAll();
    }

    @PostMapping("/selectoneuser")
    public List<Attend> selectOneUser(@RequestBody Attend attend) {
        return asi.selectOneUser(attend);
    }

    @PostMapping("/gettimequantum")
    public List<Attend> getTimeQuantum(@RequestBody TimeQuantum timeQuantum) {
        Attend attend = new Attend();
        attend.setPhoneNumber(timeQuantum.getPhoneNumber());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date startTime= null;
        Date endTime=null;
        try {
            startTime = sdf.parse(timeQuantum.getStartTime());
            endTime = sdf.parse(timeQuantum.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return asi.getTimeQuantum(attend, startTime, endTime);
    }

    @PostMapping("/insertattend")
    public ResponseEntity<Attend> insertAttend(@RequestBody Attend attend) {
        User user = new User();
        user.setPhoneNumber(attend.getPhoneNumber());
        User selectone = usi.selectone(user);
        attend.setUsername(selectone.getUsername());
        Calendar cal = Calendar.getInstance();
        attend.setCheckTime(cal.getTime());
        if(cal.get(Calendar.HOUR_OF_DAY)<12){
            attend.setType("1");
            if(cal.get(Calendar.HOUR_OF_DAY)>9){
                attend.setStatus("2");
            }else{
                attend.setStatus("1");
            }
        }else{
            attend.setType("2");
            if(cal.get(Calendar.HOUR_OF_DAY)<18){
                attend.setStatus("3");
            }else{
                attend.setStatus("1");
            }
        }
        if(asi.insertAttend(attend)==1){
            return ResponseEntity.ok(attend);
        }else{
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping("/updateattend")
    public ResponseEntity<Boolean> updateAttend(@RequestBody Attend attend) {
        return ResponseEntity.ok(asi.updateAttend(attend)==1);
    }

    @PostMapping("/deleteoneattend")
    public ResponseEntity<Boolean> deleteOneAttend(int id) {
        return ResponseEntity.ok(asi.deleteOneAttend(id)==1);
    }

    @PostMapping("/deleteoneuser")
    public ResponseEntity<Boolean> deleteOneUser(@RequestBody Attend attend) {
        return ResponseEntity.ok(asi.deleteOneUser(attend)==1);
    }
}
