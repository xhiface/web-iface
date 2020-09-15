package com.yumier.iface.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * com.yumier.iface.entity.vo
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/9/15 16:22
 * @since 1.0
 */
@ApiModel(description = "添加用户时需要的参数model")
@Getter
@Setter
@ToString
public class RegisterUserVo {
    @ApiModelProperty(value = "用户组", example = "demo", required = true)
    private String groupId;

    private String faceId;

    @ApiModelProperty(value = "用户名", example = "intent", required = true)
    private String username;

    @ApiModelProperty(value = "密码", example = "123456ab", required = true)
    private String password;

    private String role;

    @ApiModelProperty(value = "年龄", example = "18", required = true)
    private int age;

    @ApiModelProperty(value = "邮箱", example = "12345678@qq.com", required = true)
    private String email;

    @ApiModelProperty(value = "性别", example = "true", required = true)
    private boolean gender;

    @ApiModelProperty(value = "手机号", example = "18222222222", required = true)
    private String phoneNumber;
    private Date createTime;
    private Date updateTime;
}
