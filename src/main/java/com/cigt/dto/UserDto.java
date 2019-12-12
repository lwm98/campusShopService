package com.cigt.dto;

import lombok.Data;

/**
 * 用户表实体类
 */
@Data
public class UserDto {
    private int id;
    private String name;
    private String image;
    private String password;
    private String sex;
    private String phone;
    private int Information_state;
    private String autograph;
    private String created_at; //创建时间
    private String updated_at; //修改时间
    private String real_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
