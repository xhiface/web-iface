package com.yumier.iface.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * com.yumier.iface.entity.vo
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/9/15 16:30
 * @since 1.0
 */
@ApiModel(description = "获取用户时需要的参数model")
@Getter
@Setter
@ToString
public class GetUserVo {
    @ApiModelProperty(value = "手机号", example = "18222222222", required = true)
    private String phoneNumber;
}
