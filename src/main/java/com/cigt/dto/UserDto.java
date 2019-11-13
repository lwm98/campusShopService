package com.cigt.dto;

import lombok.Data;

/**
 * 用户表实体类
 */
@Data
public class UserDto {
    private int user_id;
    private String user_name;
    private String user_image;
    private String password;
    private String sex;
    private String user_phone;
    private int Information_state;
    private String user_autograph;
    private String created_at; //创建时间
    private String updated_at; //修改时间
}
