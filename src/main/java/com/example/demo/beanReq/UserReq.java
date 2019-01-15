package com.example.demo.beanReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserReq {

    @ApiModelProperty(value="用户id",dataType="Long",name="userId")
    private Long userId;

    @ApiModelProperty(value="用户姓名",dataType="String",name="userName")
    private String userName;

    @ApiModelProperty(value="性别",dataType="String",name="gender")
    private String gender;

    @ApiModelProperty(value="生日",dataType="Date",name="birthday")
    private Date birthday;
}
