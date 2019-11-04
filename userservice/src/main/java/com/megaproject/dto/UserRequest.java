package com.megaproject.dto;

import com.megaproject.enums.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String userName;
    private Integer age;
    private String userEmailId;
    @ApiModelProperty(required = true)
    private Role role;

}
