package com.yumier.iface.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hedayu
 * @date 2020/9/14
 */
@ApiModel("获取该用户一段时间内的所有打卡记录需要的Model")
@Data
public class TimeQuantum {
    @ApiModelProperty(value = "手机号", example = "18222222222", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "开始的时间", example = "2020-09-10", required = true)
    private String startTime;

    @ApiModelProperty(value = "结束的时间", example = "2020-09-15", required = true)
    private String endTime;
}
