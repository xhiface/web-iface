package com.yumier.iface.controller;

import com.yumier.iface.entity.Attend;
import com.yumier.iface.entity.TimeQuantum;
import com.yumier.iface.entity.User;
import com.yumier.iface.entity.vo.DeleteAttendVo;
import com.yumier.iface.entity.vo.GetAttendVo;
import com.yumier.iface.service.impl.AttendServiceImpl;
import com.yumier.iface.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @author intent
 * @date 2020/9/13
 */
@Api(tags = "用户打卡相关")
@RestController
@RequestMapping("/attend")
public class AttendController {
    @Autowired
    AttendServiceImpl asi;

    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value = "获取全部用户的所有打卡记录", notes = "获取成功返回用户列表，获取失败http状态码返回400")
    @PostMapping("/get-all-attend")
    public ResponseEntity<List<Attend>> getAllAttend() {
        List<Attend> attendList = asi.getAllAttend();
        if (attendList != null && !attendList.isEmpty()) {
            return ResponseEntity.ok(attendList);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @ApiOperation(value = "根据手机号获取该用户的所有打卡记录", notes = "获取成功返回用户列表，获取失败http状态码返回400")
    @PostMapping("/get-one-attend")
    public ResponseEntity<List<Attend>> getOneAttend(@RequestBody GetAttendVo getAttendVo) {
        List<Attend> attendList = asi.getOneAttend(getAttendVo.getPhoneNumber());
        if (attendList != null && !attendList.isEmpty()) {
            return ResponseEntity.ok(attendList);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @ApiOperation(value = "获取该用户一段时间内的所有打卡记录", notes = "获取成功返回用户列表，获取失败http状态码返回400")
    @PostMapping("/get-time-quantum")
    public ResponseEntity<List<Attend>> getTimeQuantum(@RequestBody TimeQuantum timeQuantum) {
        Attend attend = new Attend();
        attend.setPhoneNumber(timeQuantum.getPhoneNumber());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse(timeQuantum.getStartTime());
            endTime = sdf.parse(timeQuantum.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Attend> attendList = asi.getTimeQuantum(attend, startTime, endTime);
        if (attendList != null && !attendList.isEmpty()) {
            return ResponseEntity.ok(attendList);
        }
        return ResponseEntity.badRequest().body(null);

    }

    @ApiOperation(value = "插入打卡记录", notes = "插入成功返回插入的打卡数据，插入失败http状态码返回400")
    @PostMapping("/add-attend")
    public ResponseEntity<Attend> insertAttend(@RequestBody GetAttendVo getAttendVo) {
        // 先根据手机号获取用户
        User user = userService.getOne(getAttendVo.getPhoneNumber());
        if (user != null) {
            Attend attend = new Attend();
            attend.setPhoneNumber(getAttendVo.getPhoneNumber());
            attend.setUsername(user.getUsername());
            attend.setUsername(user.getUsername());
            Calendar cal = Calendar.getInstance();
            attend.setCheckTime(cal.getTime());
            if (cal.get(Calendar.HOUR_OF_DAY) < 12) {
                attend.setType("1");
                if (cal.get(Calendar.HOUR_OF_DAY) > 9) {
                    attend.setStatus("2");
                } else {
                    attend.setStatus("1");
                }
            } else {
                attend.setType("2");
                if (cal.get(Calendar.HOUR_OF_DAY) < 18) {
                    attend.setStatus("3");
                } else {
                    attend.setStatus("1");
                }
            }
            if (asi.insertAttend(attend)) {
                return ResponseEntity.ok(attend);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    @ApiOperation(value = "更新打卡数据", notes = "更新成功返回true，更新失败http状态码返回400")
    @PostMapping("/update-attend")
    public ResponseEntity<Boolean> updateAttend(@RequestBody Attend attend) {
        if (asi.updateAttend(attend)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @ApiOperation(value = "根据id删除一个打卡", notes = "删除成功返回true，删除失败http状态码返回400")
    @PostMapping("/delete-one-attend")
    public ResponseEntity<Boolean> deleteOneAttend(int id) {
        if (asi.deleteOneAttend(id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @ApiOperation(value = "根据手机号删除用户的所有打卡", notes = "删除成功返回true，删除失败http状态码返回400")
    @PostMapping("/delete-one-user")
    public ResponseEntity<Boolean> deleteAllAttend(@RequestBody DeleteAttendVo deleteAttendVo) {
        if (asi.deleteOneUser(deleteAttendVo.getPhoneNumber())) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }
}
